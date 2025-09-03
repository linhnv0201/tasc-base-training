
select * from customer;
select * from payment;

# câu lệnh full tính năng cơ bản
SELECT c.customer_id, c.first_name, c.last_name, SUM(p.amount) AS total_payment
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
WHERE p.payment_date >= '2005-07-01'
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING SUM(p.amount) > 100
ORDER BY total_payment DESC
LIMIT 5;

#inner join
SELECT c.customer_id, c.first_name, c.last_name, p.payment_id, p.amount
FROM customer c
INNER JOIN payment p ON c.customer_id = p.customer_id
LIMIT 10;

#inner join
SELECT c.customer_id, c.first_name, c.last_name, p.payment_id, p.amount
FROM customer c
LEFT JOIN payment p ON c.customer_id = p.customer_id
WHERE p.payment_id IS NULL
LIMIT 10;

#right join
SELECT c.customer_id, c.first_name, c.last_name, p.payment_id, p.amount
FROM customer c
right join payment p on c.customer_id = p.customer_id
limit 10;

#full outer join
SELECT c.customer_id, c.first_name, c.last_name, p.payment_id, p.amount
FROM customer c
LEFT JOIN payment p ON c.customer_id = p.customer_id
UNION
SELECT c.customer_id, c.first_name, c.last_name, p.payment_id, p.amount
FROM customer c
RIGHT JOIN payment p ON c.customer_id = p.customer_id;

# cross join Ví dụ: Lấy mọi cặp kết hợp giữa 5 khách hàng đầu tiên và 5 bộ phim đầu tiên:
SELECT c.first_name, f.title
FROM customer c
CROSS JOIN film f
LIMIT 25;




