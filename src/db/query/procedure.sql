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
