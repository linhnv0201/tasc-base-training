#top thanh toán theo từng khách
--row_num = 1, 2, 3,… liên tục, không quan tâm giá trị total_payment trùng hay không.
SELECT c.customer_id, c.first_name, c.last_name,
       SUM(p.amount) AS total_payment,
       ROW_NUMBER() OVER (ORDER BY SUM(p.amount) DESC) AS row_num
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
LIMIT 10;
--GROUP BY c.customer_id, c.first_name, c.last_name


--1 1 3 4
SELECT c.customer_id, c.first_name, c.last_name,
       SUM(p.amount) AS total_payment,
       RANK() OVER (ORDER BY SUM(p.amount) DESC) AS row_num
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
LIMIT 10;

--1 1 2 3
SELECT c.customer_id, c.first_name, c.last_name,
       SUM(p.amount) AS total_payment,
       DENSE_RANK() OVER (ORDER BY SUM(p.amount) DESC) AS row_num
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name
LIMIT 10;