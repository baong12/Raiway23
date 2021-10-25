DROP DATABASE IF EXISTS assignment4_db;
CREATE DATABASE assignment4_db;
ALTER DATABASE assignment4_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE assignment4_db;

-- Question 1: Create the tables (with the most appropriate/economic field/column
-- constraints & types)
-- Question 2: Add at least 10 records into created table
DROP TABLE IF EXISTS department;
CREATE TABLE department(
    department_number   SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name     VARCHAR(50) CHAR SET utf8mb4 NOT NULL
);
INSERT INTO department(department_name)
VALUES  ('Quản trị'),
        ('Nhân sự'),
        ('Kinh tế'),
        ('Quản lý'),
        ('Kho vận'),
        ('Kĩ thuật'),
        ('Kinh doanh'),
        ('Đào tạo'),
        ('Truyền thông'),
        ('Bảo vệ');

DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
    employee_number     SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_name       VARCHAR(50) CHAR SET utf8mb4 NOT NULL
);
INSERT INTO employee(employee_name)
VALUES  ('Nguyễn Thành Long'),
        ('Ngô Hoàng Sơn'),
        ('Vũ Thái Huy'),
        ('Trần Mạnh Duy'),
        ('Huỳnh Quang Ngọc'),
        ('Phạm Hồng Ngọc'),
        ('Trịnh Thanh Thủy'),
        ('Phí Hương Giang'),
        ('Nguyễn Anh Thư'),
        ('Hồ Phương Anh');

DROP TABLE IF EXISTS employee_skill;
CREATE TABLE employee_skill(
    employee_number     SMALLINT NOT NULL,
    skill_code          VARCHAR(20) NOT NULL,
    date_registered     DATE,
    PRIMARY KEY (employee_number, skill_code),
    FOREIGN KEY (employee_number) REFERENCES employee(employee_number) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO employee_skill(employee_number, skill_code)
VALUES  (1, 'Java', '2021-10-25'),
        (1, 'Python', '2021-10-25'),
        (2, 'Dotnet', '2021-10-25'),
        (2, 'Java', '2021-10-25'),
        (3, 'SQL', '2021-10-25'),
        (4, 'Ruby', '2021-10-25'),
        (5, 'Frontend', '2021-10-25'),
        (6, 'Fullstack', '2021-10-25'),
        (6, 'StackOverflow', '2021-10-25'),
        (7, 'W3school', '2021-10-25');
        
-- Question 3: Query all Employee (include: name) who has Java skill
-- Instruction: Using UNION
SELECT * FROM employee_skill;
SELECT * FROM employee;

SELECT e.employee_name, es.skill_code
FROM employee e
JOIN employee_skill es ON e.employee_number = es.employee_number
WHERE es.skill_code = 'Java';

-- Question 4: Query all department which has more than 3 employee
DROP TABLE IF EXISTS department_employee;
CREATE TABLE department_employee(
    department_number   SMALLINT NOT NULL,
    employee_number     SMALLINT NOT NULL,
    PRIMARY KEY (department_number, employee_number),
    FOREIGN KEY (department_number) REFERENCES department(department_number) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (employee_number) REFERENCES employee(employee_number) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO department_employee(department_number, employee_number)
VALUES  (1, 1),
        (1, 2),
        (1, 3),
        (2, 2),
        (3, 4),
        (4, 6),
        (6, 8),
        (8, 10),
        (10, 2),
        (1, 4),
        (3, 5),
        (5, 3),
        (7, 2),
        (9, 5);
        
SELECT d.department_name, COUNT(de.employee_number) AS 'Employee number'
FROM department d
JOIN department_employee de ON d.department_number = de.department_number
GROUP BY d.department_number
HAVING COUNT(de.employee_number) > 3;
        
-- Question 5: Query all employee of each department.
-- Instruction: Using GROUP BY
SELECT * FROM department_employee;

SELECT d.department_name, GROUP_CONCAT(e.employee_name) AS 'List of employees'
FROM department d
LEFT JOIN department_employee de ON d.department_number = de.department_number
LEFT JOIN employee e ON de.employee_number = e.employee_number
GROUP BY d.department_number;

-- Question 6: Query all Employee (include: name) who has more than 1 skills.
-- Instruction: Using DISTINCT
SELECT * FROM employee_skill;
SELECT * FROM employee;

SELECT DISTINCT e.employee_name, COUNT(es.skill_code) AS 'Skill_count'
FROM employee e
JOIN employee_skill es ON e.employee_number = es.employee_number
GROUP BY e.employee_number
HAVING COUNT(es.skill_code) > 1;
