-- Question 1: Thêm ít nhất 10 record vào mỗi table
-- Đã làm ở assignment 2

USE testing_system;
-- Question 2: lấy ra tất cả các phòng ban
SELECT department_name
FROM department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT department_id
FROM department
WHERE department_name = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT *
FROM `account`
WHERE LENGTH(full_name) = (
    SELECT MAX(LENGTH(full_name))
    FROM `account`
);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT *
FROM `account`
WHERE LENGTH(full_name) = (
    SELECT MAX(LENGTH(full_name))
    FROM `account`
) AND department_id = 3;
