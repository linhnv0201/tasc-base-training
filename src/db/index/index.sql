CREATE INDEX idx_customer_lastname ON customer(last_name);
ALTER TABLE customer DROP INDEX idx_customer_lastname;

select * from customer
where customer_id > 5;

EXPLAIN SELECT * FROM customer
WHERE last_name = 'Smith';
SELECT * FROM customer
WHERE last_name = 'Evans';

show index from customer;

