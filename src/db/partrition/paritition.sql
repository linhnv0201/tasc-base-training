--tạo bảng tạo luôn partition
CREATE TABLE payment_partitioned (
    payment_id SMALLINT NOT NULL,
    customer_id SMALLINT NOT NULL,
    staff_id TINYINT NOT NULL,
    rental_id INT DEFAULT NULL,
    amount DECIMAL(5,2) NOT NULL,
    payment_date DATETIME NOT NULL
)
PARTITION BY RANGE (YEAR(payment_date)) (
    PARTITION p2005 VALUES LESS THAN (2006),
    PARTITION p2006 VALUES LESS THAN (2007),
    PARTITION p2007 VALUES LESS THAN (2008),
    PARTITION pmax VALUES LESS THAN MAXVALUE
);

-- sao chép dữ liệu
INSERT INTO payment_partitioned
SELECT payment_id, customer_id, staff_id, rental_id, amount, payment_date
FROM payment;

--xem các partition hiện có
SELECT
    PARTITION_NAME,
    PARTITION_METHOD,
    PARTITION_EXPRESSION,
    TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_SCHEMA = 'sakila'
  AND TABLE_NAME = 'payment_partitioned';

--SHOW CREATE TABLE payment_partitioned\G
SHOW CREATE TABLE payment_partitioned;
-- xóa all partition
ALTER TABLE payment_partitioned REMOVE PARTITIONING;
--chia lại partition
ALTER TABLE payment_partitioned
PARTITION BY RANGE (TO_DAYS(payment_date)) (
    PARTITION p_before VALUES LESS THAN (TO_DAYS('2005-06-25 11:30:37')),
    PARTITION p_mid    VALUES LESS THAN (TO_DAYS('2005-08-23 11:25:00')),
    PARTITION p_after  VALUES LESS THAN MAXVALUE
);

select * from payment;
select * from payment_partitioned;

SELECT *
FROM payment
WHERE payment_id = (SELECT MIN(payment_id) FROM payment);
