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

--tìm 5KH có payment.amount lớn nhất mà giao dịch sau ngày 2006-01-01
WITH customer_payment AS (
    SELECT
        p.customer_id,
        SUM(p.amount) AS total_payment
    FROM payment p
    WHERE p.payment_date > '2006-01-01'
    GROUP BY p.customer_id
)
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    cp.total_payment
FROM customer c
JOIN customer_payment cp ON c.customer_id = cp.customer_id
ORDER BY cp.total_payment DESC
LIMIT 5;


