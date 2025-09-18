select * from customer;
select * from payment;
#Tìm Top 5 khách hàng trả tiền nhiều nhất, hiển thị customer_id, first_name, last_name,
select c.customer_id, c.first_name, c.last_name, sum(p.amount) as payment_amount
from customer c
join payment p on c.customer_id = p.customer_id
group by c.customer_id, c.first_name, c.last_name
order by payment_amount
limit 6;

#Số lượng phim mỗi diễn viên tham gia, lấy top 5
select a.actor_id, a.first_name, a.last_name, count(fa.film_id) as number_of_film
from actor a
join film_actor fa on a.actor_id = fa.actor_id
group by a.actor_id, a.first_name, a.last_name
order by number_of_film desc
limit 5;

-- tổng 3 khách có tổng thanh toán cao nhất mỗi cửa hàng
WITH customer_totals AS (
    SELECT
        c.store_id,
        c.customer_id,
        c.first_name,
        c.last_name,
        SUM(p.amount) AS total_payment
    FROM customer c
    JOIN payment p ON c.customer_id = p.customer_id
    GROUP BY c.store_id, c.customer_id, c.first_name, c.last_name
)
SELECT *,
       RANK() OVER (PARTITION BY store_id ORDER BY total_payment DESC) AS rank_in_store
FROM customer_totals
WHERE total_payment > 0
ORDER BY store_id, rank_in_store
LIMIT 20;  -- Lấy thử 20 dòng đầu tiên

select * from payment
where amount = (select max(amount) from payment);

#tìm 5KH có payment.amount lớn nhất mà giao dịch sau ngày 2006-01-01
select * from customer;
select * from payment;
WITH customer_payment AS (
    SELECT c.customer_id, c.first_name, c.last_name, sum(p.amount) as payment_amount
    FROM customer c
    JOIN payment p on c.customer_id = p.customer_id
    where p.payment_date > '2006-01-01'
    group by c.customer_id, c.first_name, c.last_name
)
SELECT * from customer_payment
order by payment_amount desc
limit 5;

#tạo 1 view hiển thị số phim mà mỗi actor tham gia, sau đó truy vấn 5 actor có nhiều phim nhất
CREATE OR REPLACE view actor_film_count as
SELECT a.actor_id, a.first_name, a.last_name, count(fa.film_id) as count_film
FROM actor a
join film_actor fa on a.actor_id = fa.actor_id
group by a.actor_id, a.first_name, a.last_name;
# DROP VIEW IF EXISTS actor_film_count;
select * from actor_film_count
order by count_film desc
limit 10;

CREATE PROCEDURE GetFilmCount(IN a_id int)
BEGIN
    SELECT count_film
    FROM actor_film_count
    where actor_id = a_id;
end;
# drop procedure GetFilmCount;
CALL GetFilmCount(1);

#Viết một Stored Procedure có tên GetCustomerRentalHistory nhận tham số đầu vào là customer_id.
#Yêu cầu: Trả về danh sách tất cả các phim mà khách hàng đó đã thuê, kèm theo: film_title, rental_date, return_date
#Kết quả sắp xếp theo rental_date giảm dần.
CREATE PROCEDURE GetCustomerRentalHistory(IN cust_id int)
BEGIN
    SELECT f.title, r.rental_date, r.return_date
    FROM customer c
    JOIN rental r on c.customer_id = r.customer_id
    JOIN inventory i on r.inventory_id = i.inventory_id
    join film f on i.film_id = f.film_id
    where c.customer_id = cust_id;
end;
# DROP PROCEDURE procedure_name;
call GetCustomerRentalHistory(1);
call GetCustomerRentalHistory(2);

#subquery cơ bản
SELECT customer_id, first_name, last_name
FROM customer
WHERE customer_id IN (
    SELECT customer_id
    FROM payment
    GROUP BY customer_id
    HAVING SUM(amount) > 200
);

#dùng subquery tìm 5 kh có tổng thanh toán cao nhât
select * from customer;
select * from payment;
select customer_id, first_name, last_name, total_payment
from (
select c.customer_id, c.first_name, c.last_name, sum(p.amount) as total_payment
from customer c
join payment p on c.customer_id = p.customer_id
group by c.customer_id, c.first_name, c.last_name
order by total_payment desc ) as x
limit 5;

select c.customer_id, c.first_name, c.last_name, sum(p.amount) as total_payment
from customer c
join payment p on c.customer_id = p.customer_id
group by c.customer_id, c.first_name, c.last_name
order by total_payment desc
limit 5;



