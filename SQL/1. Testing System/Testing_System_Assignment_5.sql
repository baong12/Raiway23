USE testing_system;

-- Exercise 1: Tiếp tục với Database Testing System
-- (Sử dụng subquery hoặc CTE)

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
SELECT * FROM `account`;
DROP VIEW IF EXISTS v_danh_sach_sales;

-- NOT using subquery
CREATE VIEW v_danh_sach_sales AS
    SELECT d.department_name, a.full_name
    FROM `account` a
    JOIN department d ON d.department_id = a.department_id
    WHERE d.department_name = 'Sales';

-- Using subquery
CREATE VIEW v_danh_sach_sales AS
    SELECT department_name, full_name
    FROM (
        SELECT d.department_name, a.full_name
        FROM `account` a
        JOIN department d ON d.department_id = a.department_id
    ) AS t1
    WHERE department_name = 'Sales';

SELECT * FROM v_danh_sach_sales;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
SELECT * FROM group_account;
DROP VIEW IF EXISTS v_acc_nhieu_gr_nhat;

-- Using CTE
CREATE VIEW v_acc_nhieu_gr_nhat AS
    WITH
        acc_trong_gr AS (
            SELECT a.full_name, COUNT(ga.group_id) AS group_count
            FROM `account` a
            JOIN group_account ga ON ga.account_id = a.account_id
            GROUP BY a.account_id
        )
    SELECT *
    FROM acc_trong_gr
    WHERE group_count = (
        SELECT MAX(group_count)
        FROM acc_trong_gr
    );

-- Using subquery
CREATE VIEW v_acc_nhieu_gr_nhat AS
    SELECT a.full_name, COUNT(ga.group_id) AS group_count
    FROM `account` a
    JOIN group_account ga ON ga.account_id = a.account_id
    GROUP BY a.account_id
    HAVING group_count = (
        SELECT MAX(t1.group_count)
        FROM (
            SELECT COUNT(group_id) AS group_count
            FROM group_account
            GROUP BY account_id
        ) AS t1
    );
    
SELECT * FROM v_acc_nhieu_gr_nhat;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS v_content_300_word;

-- NOT using subquery
CREATE VIEW v_content_300_word AS
    SELECT content, (LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1) AS word_count
    FROM question
    WHERE LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1 > 300;

-- Using subquery
CREATE VIEW v_content_300_word AS
    SELECT *
    FROM (
        SELECT content, (LENGTH(content) - LENGTH(REPLACE(content, ' ', '')) + 1) AS word_count
        FROM question
    ) AS t1
    WHERE word_count > 300;

SELECT * FROM v_content_300_word;
DELETE FROM v_content_300_word; -- Can only delete when NOT using subquery (???)

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS v_dep_nhieu_acc_nhat;

-- Using CTE
CREATE VIEW v_dep_nhieu_acc_nhat AS
    WITH
        dep_most_acc AS (
            SELECT d.department_name, COUNT(a.account_id) AS acc_count
            FROM department d
            JOIN `account` a ON d.department_id = a.department_id
            GROUP BY d.department_id
        )
    SELECT *
    FROM dep_most_acc
    WHERE acc_count = (
        SELECT MAX(acc_count)
        FROM dep_most_acc
    );

-- Using subquery
CREATE VIEW v_dep_nhieu_acc_nhat AS
    SELECT d.department_name, COUNT(a.account_id) AS acc_count
    FROM department d
    JOIN `account` a ON d.department_id = a.department_id
    GROUP BY d.department_id
    HAVING acc_count = (
        SELECT MAX(t1.acc_count)
        FROM (
            SELECT COUNT(account_id) AS acc_count
            FROM `account`
            GROUP BY department_id
        ) AS t1
    );
    
SELECT * FROM v_dep_nhieu_acc_nhat;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
SELECT * FROM question;

DROP VIEW IF EXISTS v_q_of_nguyen;

-- Using subquery, solution 1
CREATE VIEW v_q_of_nguyen AS
    SELECT q.content, a.full_name
    FROM question q
    JOIN `account` a ON q.creator_id = a.account_id
    WHERE a.full_name IN (
        SELECT full_name
        FROM `account`
        WHERE full_name LIKE 'Nguyễn%'
    );

-- Using subquery, solution 2
CREATE VIEW v_q_of_nguyen AS
    SELECT content, full_name
    FROM (
        SELECT q.content, a.full_name
        FROM question q
        JOIN `account` a ON q.creator_id = a.account_id
    ) AS t1
WHERE full_name LIKE 'Nguyễn%';

SELECT * FROM v_q_of_nguyen;