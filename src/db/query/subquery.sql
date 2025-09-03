
#dùng subquery để tính thêm tổng thanh toán của 1 ng
-- lỗi dòng 57 do parser
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    (
        SELECT COUNT(*)
        FROM payment AS p
        WHERE p.customer_id = c.customer_id
    ) AS payment_count
FROM customer AS c
LIMIT 10;



#dùng subquery trong from để tính tổng tiền khách hàng rồi lọc lấy 5
select t.customer_id, total_payment
from (
    select customer_id , sum(amount) as total_payment
    from payment
    group by customer_id
) as t
order by total_payment desc
limit 10;

# dùng subquery trong where lọc KH có payment > 200
select c.customer_id, c.last_name,
from customer c
where c.customer_id in (
  select p.customer_id
  from payment p
  group by p.customer_id
  having sum(p.amount) > 100
);

# với cách trên, muốn in ra cả amount thì nên dùng cách khác
--c1
SELECT c.customer_id, c.first_name, c.last_name, p.total_amount
FROM customer c
JOIN (
    SELECT p.customer_id, SUM(p.amount) AS total_amount
    FROM payment p
    GROUP BY p.customer_id
    HAVING SUM(p.amount) > 100
) p ON c.customer_id = p.customer_id
ORDER BY p.total_amount desc;
--c2
SELECT c.customer_id, c.first_name, c.last_name, SUM(p.amount) AS total_amount
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING SUM(p.amount) > 100;

# Correlated subquery
--Subquery chạy mỗi lần cho từng dòng ở outer query.
-- Ví dụ: Lấy danh sách khách hàng mà tổng tiền thanh toán lớn hơn mức trung bình của chính họ trong từng lần thanh toán.
-- SELECT 1 là một dạng subquery tối giản, không quan tâm dữ liệu thực tế, chỉ trả về giá trị 1.
             --Thường dùng trong EXISTS hoặc kiểm tra điều kiện:
SELECT c.customer_id, c.first_name, c.last_name
FROM customer c
WHERE EXISTS (
    SELECT 1
    FROM payment p
    WHERE p.customer_id = c.customer_id
      AND p.amount > (
          SELECT AVG(p2.amount)
          FROM payment p2
          WHERE p2.customer_id = c.customer_id
      )
);
