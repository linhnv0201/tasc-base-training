-- Tạo 1 bảng cte và có thể dùng nhiều kiểu select từ bảng này khác nhau
WITH customer_payment AS (
    SELECT c.customer_id, c.first_name, c.last_name, SUM(p.amount) AS total_payment
    FROM customer c
    JOIN payment p ON c.customer_id = p.customer_id
    GROUP BY c.customer_id, c.first_name, c.last_name
)
SELECT *
FROM customer_payment
ORDER BY total_payment DESC
LIMIT 5;

SELECT AVG(total_payment) AS avg_payment FROM customer_payment;

SELECT *
FROM customer_payment
WHERE total_payment > 200;


