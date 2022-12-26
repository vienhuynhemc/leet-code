SELECT employee_id,
       CASE
           WHEN (
                       name NOT LIKE 'M%'
                   AND MOD(employee_id, 2) = 1)
               THEN salary
           ELSE 0
           END AS bonus
FROM Employees