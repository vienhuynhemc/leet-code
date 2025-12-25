SELECT
  customer_number
FROM
  Orders
GROUP BY
  customer_number
HAVING
  COUNT(order_number) = (
    SELECT
      MAX(t.num_of_orders)
    FROM
      (
        SELECT
          COUNT(order_number) AS num_of_orders
        FROM
          Orders
        GROUP BY
          customer_number
      ) t
  );
