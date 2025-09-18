--GetCustomerPayment là tên procedure
-- cust_id là tham số đầu vào
-- Procedure này tính tổng thanh toán của một khách hàng
DELIMITER //

CREATE PROCEDURE GetCustomerPayment(IN cust_id INT)
BEGIN
    SELECT c.customer_id, c.first_name, c.last_name, SUM(p.amount) AS total_payment
    FROM customer c
    JOIN payment p ON c.customer_id = p.customer_id
    WHERE c.customer_id = cust_id
    GROUP BY c.customer_id, c.first_name, c.last_name;
END;

DELIMITER ;

drop procedure GetCustomerPayment;

CALL GetCustomerPayment(2);
CALL GetCustomerPayment(1);

#top 5 customer after 2006
CREATE PROCEDURE top5_customers_after_2006()
BEGIN
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
END;
call top5_customers_after_2006();