DROP TABLE IF EXISTS test_data;
CREATE TABLE test_data (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    created_at DATETIME,
    email VARCHAR(100),
    dob DATE
);

SET SESSION cte_max_recursion_depth = 1000000;

-- Recursive CTE để sinh số từ 1 -> 1,000,000
INSERT INTO test_data (id, name, created_at, email, dob)
WITH RECURSIVE numbers AS (
    SELECT 1 AS n
    UNION ALL
    SELECT n + 1 FROM numbers WHERE n < 1000000
)
SELECT
    n,
    CONCAT('User_', n),
    NOW() - INTERVAL (RAND() * 3650) DAY,               -- created_at random trong 10 năm
    CONCAT('user', n, '@example.com'),
    DATE('1970-01-01') + INTERVAL (RAND() * 15000) DAY  -- dob random 1970 -> 2011
FROM numbers;

show index from test_data;
# DROP TABLE test_data;

create index idx_name on test_data(name);
DROP INDEX idx_name ON test_data;

#thử nghiệm
# ~277ms khi chưa đánh index
select * from test_data
where name = 'User_1' and dob = '2002-05-03';

# ví dụ đánh index cho 1 mình name (đánh index này mất ~3s :vv)
create index idx_name on test_data(name);

#chậm, 293ms, về lý thuyết thì giúp nhưng vẫn chậm
# chạy explain cho thấy optimizer chạy full table scan
EXPLAIN ANALYZE select * from test_data
where name like 'User_823122%';

EXPLAIN ANALYZE
SELECT *
FROM test_data FORCE INDEX (idx_name)
WHERE name LIKE 'User_823122%';


#chậm, 322ms
select * from test_data
where name like '%9930%';

#chậm, 322ms
select * from test_data
where name like '%9930';

#chạy lại mất khoảng 40ms
select * from test_data
where name = 'User_999630' and dob = '1999-03-22';

#đảo vị trí cũng mất 40ms
select * from test_data
where dob = '1999-03-22' and name = 'User_999630';

# có thể đánh index chồng chéo như này, khi dùng cái nào thì tùy optimizer
# ví dụ chỉ có 2 index này thì khi chỉ tìm kiếm với dob thì ko dùng đc index nào :vv
CREATE INDEX idx_name ON test_data(name);
# đánh composite idx này mất ~ 3.5s
CREATE INDEX idx_name_dob ON test_data(name, dob);
# drop index idx_name_dob ON test_data;

#chạy lại cũng chỉ mất ~40ms cho cả 2 dù đảo hay ko
explain analyze select * from test_data
where name = 'User_999630' and dob = '1999-03-22';

#Index chỉ hoạt động khi LIKE 'User_99%' (bắt đầu bằng prefix).
# Nếu bạn viết LIKE '%99' hoặc LIKE '%99%' thì index sẽ bị vô hiệu → MySQL buộc phải quét toàn bộ.
#chạy lần 1 mất ~249ms lần 2 ~206ms
EXPLAIN ANALYZE select * from test_data
where name like 'User_99%' and dob between '1999-03-22' and '2002-12-12';

#chạy lần 1 mất ~80ms
EXPLAIN ANALYZE select * from test_data
where name like '%99%' and dob between '1999-03-22' and '2002-12-12';

#đảo lại vẫn ok chỉ mất ~210ms
SELECT * FROM test_data
WHERE dob BETWEEN '1999-03-22' AND '2002-12-12'
  AND name LIKE 'User_99%';

# đánh index mất 4.2s
CREATE INDEX idx_name_email_dob ON test_data(name,email, dob);
drop index idx_name_email_dob on test_data;

# mất 317ms , ko khác gì chưa đánh index
select * from test_data
where name like '%99%'
  AND email = 'user997@example.com'
  AND dob between '1999-03-22' and '2002-12-12';

#thay like -> = thì đánh đc chỉ mất 39ms
select * from test_data
where name = 'User_997'
  AND email = 'user997@example.com'
  AND dob between '1999-03-22' and '2002-12-12';

# đảo thứ tự vẫn 49ms ,Dù bạn viết theo thứ tự nào thì kết quả vẫn y hệt. Chỉ có index nào tồn tại mới quyết định được MySQL dùng index ra sao.
 SELECT * FROM test_data
WHERE name = 'User_997'
AND email = 'user997@example.com'
 and dob BETWEEN '1999-03-22' AND '2002-12-12'
  ;

 SELECT * FROM test_data
WHERE dob BETWEEN '1999-03-22' AND '2002-12-12'
  AND email = 'user997@example.com'
  AND name = 'User_997';

# index ko có tác dụng, 300ms
SELECT *
FROM test_data
WHERE dob BETWEEN '1999-03-22' AND '2002-12-12'
  AND email = 'user997@example.com';

show index from test_data;



