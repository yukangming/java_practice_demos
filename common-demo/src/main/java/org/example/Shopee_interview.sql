/**
  Then I still have a database problem now.
  There is an employee table and a department table.
  The employee table has four fields: number, employee name, department number, and salary.
  The department table has both a number and a name.
  The department number in the employee table is the foreign key of the department table.
  Now, high-income employees are defined as the top five of different salaries in a department.
  Please write an SQL statement to query out high-income employees.
  The query results should be the employee's name, department name and salary
 */

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE department
(
    dept_no   INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

CREATE TABLE employee
(
    emp_no   INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_no  INT,
    salary   INT,
    FOREIGN KEY (dept_no) REFERENCES department (dept_no)
);

INSERT INTO department
VALUES (1, 'Engineering'),
       (2, 'Sales'),
       (3, 'HR');

-- Engineering dept
INSERT INTO employee
VALUES (1, 'Alice', 1, 12000),
       (2, 'Bob', 1, 11800),
       (3, 'Cindy', 1, 11500),
       (4, 'David', 1, 11000),
       (5, 'Eric', 1, 10800),
       (6, 'Frank', 1, 9500),
       (7, 'George', 1, 9000);

-- Sales dept
INSERT INTO employee
VALUES (8, 'Helen', 2, 15000),
       (9, 'Ian', 2, 14500),
       (10, 'Jack', 2, 13000),
       (11, 'Kelly', 2, 12800),
       (12, 'Leo', 2, 12500),
       (13, 'Mike', 2, 10000);

-- HR dept
INSERT INTO employee
VALUES (14, 'Nina', 3, 9000),
       (15, 'Oscar', 3, 8500),
       (16, 'Peter', 3, 8300),
       (17, 'Queen', 3, 8200),
       (18, 'Rose', 3, 8000),
       (19, 'Steve', 3, 7000);

SELECT e.emp_name,
       d.dept_name,
       e.salary
FROM employee e
         JOIN department d ON e.dept_no = d.dept_no
WHERE (SELECT COUNT(*)
       FROM employee e2
       WHERE e2.dept_no = e.dept_no
         AND e2.salary > e.salary) < 5
ORDER BY d.dept_name, e.salary DESC;
