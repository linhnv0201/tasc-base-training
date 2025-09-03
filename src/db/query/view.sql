
CREATE VIEW top_customers AS
SELECT c.customer_id, c.first_name, c.last_name, SUM(p.amount) AS total_payment
FROM customer c
JOIN payment p ON c.customer_id = p.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name;

SELECT * FROM top_customers;

CREATE VIEW simple_customer AS
SELECT customer_id, first_name, last_name
FROM customer;

--Create trên view
-- đây đang lỗi do db sakila có những ràng buộc cho các column khác not null
INSERT INTO simple_customer (customer_id, first_name, last_name)
VALUES (101, 'Vu', 'Linh');
-- UPDATE trên VIEW
UPDATE simple_customer
SET first_name = 'Vu'
WHERE customer_id = 1;

select * from simple_customer;
select * from customer;
-- DELETE trên VIEW delete đc nhưng ví dụ này ko đc vì ràng buộc với các table khác
--DELETE FROM simple_customer WHERE customer_id = 2;


