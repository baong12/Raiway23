USE testing_system;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
DROP TRIGGER IF EXISTS trg_insert_group;
DELIMITER $$
CREATE TRIGGER trg_insert_group
    BEFORE INSERT ON `group`
    FOR EACH ROW
        BEGIN
            IF NEW.create_date < DATE_SUB(curdate(), INTERVAL 1 YEAR) THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Ngày tạo không hợp lệ';
            END IF;
        END$$
DELIMITER ;

INSERT INTO `group`(group_name, creator_id, create_date) VALUES
    ('Group 100', 5, '2021-09-30');
INSERT INTO `group`(group_name, creator_id, create_date) VALUES
    ('Group 100', 5, '2020-10-30');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
DROP TRIGGER IF EXISTS trg_insert_user;
DELIMITER $$
CREATE TRIGGER trg_insert_user
    BEFORE INSERT ON `account`
    FOR EACH ROW
        BEGIN
            IF NEW.department_id = (
                SELECT department_id FROM department
                WHERE department_name = 'Sales'
            ) THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
            END IF;
        END$$
DELIMITER ;

INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date) VALUES
    ('donan_trum@gmail.com', 'donan_trum', 'Donald Trump', 2, 1, '2010-10-18');

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS trg_insert_group_max5;
DELIMITER $$
CREATE TRIGGER trg_insert_group_max5
    BEFORE INSERT ON group_account
    FOR EACH ROW
        BEGIN
            DECLARE acc_count TINYINT;
            SELECT COUNT(account_id) INTO acc_count FROM group_account
            WHERE group_id = NEW.group_id
            GROUP BY group_id;
            
            IF acc_count >= 5 THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'This group cannot add more than 5 users.';
            END IF;
        END$$
DELIMITER ;

INSERT INTO group_account(group_id, account_id, join_date) VALUES
    (2, 10, '2021-10-14'),
    (2, 9, '2021-10-14'),
    (2, 8, '2021-10-14'),
    (2, 7, '2021-10-14'),
    (2, 6, '2021-10-14');
SELECT * FROM group_account;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS trg_insert_exam_max10_question;
DELIMITER $$
CREATE TRIGGER trg_insert_exam_max10_question
    BEFORE INSERT ON exam_question
    FOR EACH ROW
        BEGIN
            DECLARE q_count TINYINT;
            SELECT COUNT(question_id) INTO q_count FROM exam_question
            WHERE exam_id = NEW.exam_id
            GROUP BY exam_id;
            
            IF q_count >= 10 THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'This exam cannot have more than 10 questions.';
            END IF;
        END$$
DELIMITER ;

INSERT INTO exam_question(exam_id, question_id) VALUES
    (1, 9),
    (1, 8),
    (1, 7),
    (1, 6),
    (1, 5),
    (1, 4),
    (1, 3),
    (1, 1),
    (1, 10),
    (1, 11);
SELECT * FROM exam_question;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
DROP TRIGGER IF EXISTS trg_delete_email_admin;
DELIMITER $$
CREATE
 TRIGGER trg_delete_email_admin
    BEFORE DELETE ON `account`
    FOR EACH ROW
        BEGIN
            IF OLD.email = 'admin@gmail.com' THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'This account "admin@gmail.com" cannot be deleted.';
            END IF;
        END$$
DELIMITER ;

INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)
VALUES ('admin@gmail.com', 'administrator', 'Quản trị viên', 1, 1, '2021-11-01');
DELETE FROM `account`
WHERE email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

-- Tạo bản sao của table 'account'
DROP TABLE IF EXISTS account_copy;
CREATE TABLE account_copy LIKE `account`;
-- Sửa lại ràng buộc trường 'deparment_id'
ALTER TABLE account_copy MODIFY department_id TINYINT;

DROP TRIGGER IF EXISTS trg_insert_account_departmentid_null; 
DELIMITER $$
CREATE TRIGGER trg_insert_account_departmentid_null
    BEFORE INSERT ON account_copy
    FOR EACH ROW
        BEGIN
            IF NEW.department_id IS NULL THEN
                SET NEW.department_id = (
                    SELECT department_id FROM department
                    WHERE department_name = 'Waiting room'
                );
            END IF;
        END$$
DELIMITER ;

INSERT INTO account_copy(email, user_name, full_name, position_id, create_date)
VALUES ('dai.vu@gmail.com', 'dai.vu', 'Vũ Văn Đại', 1, '2021-11-01');
SELECT * FROM account_copy;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS trg_insert_answer_limit;
DELIMITER $$
CREATE TRIGGER trg_insert_answer_limit
    BEFORE INSERT ON answer
    FOR EACH ROW
        BEGIN
            DECLARE ans_count TINYINT;
            DECLARE correct_ans_count TINYINT;
            
            SELECT COUNT(answer_id) INTO ans_count FROM answer
            WHERE question_id = NEW.question_id;
            
            IF ans_count >= 4 THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'This question cannot have more than 4 answers.';
            END IF;
            
            SELECT COUNT(answer_id) INTO correct_ans_count FROM answer
            WHERE question_id = NEW.question_id
                AND is_correct = TRUE;
            
            IF correct_ans_count >= 2
                AND NEW.is_correct = TRUE
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'This question cannot have more than 2 correct answers.';
            END IF;
        END$$
DELIMITER ;

DELETE FROM answer;
SELECT * FROM answer; 
INSERT INTO answer(content, question_id, is_correct)
VALUES  ('Là ngôn ngữ lập trình', 1, TRUE),
        ('Là ngôn ngữ lập trình', 1, TRUE),
        ('Không là ngôn ngữ lập trình', 1, FALSE),
        ('Không là ngôn ngữ lập trình', 1, FALSE),
        ('Không là ngôn ngữ lập trình', 1, FALSE);
INSERT INTO answer(content, question_id, is_correct)
VALUES  ('Là ngôn ngữ lập trình', 2, TRUE),
        ('Là ngôn ngữ lập trình', 2, TRUE),
        ('Là ngôn ngữ lập trình', 2, TRUE),
        ('Không là ngôn ngữ lập trình', 2, FALSE);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

-- Tạo bản sao của table 'account'
DROP TABLE IF EXISTS account_copy;
CREATE TABLE account_copy LIKE `account`;
-- Thêm trường 'gender'
ALTER TABLE account_copy ADD gender VARCHAR(20);

DROP TRIGGER IF EXISTS trg_gender_input_modify;
DELIMITER $$
CREATE TRIGGER trg_gender_input_modify
BEFORE INSERT ON account_copy
FOR EACH ROW
    BEGIN
        IF NEW.gender = 'nam' THEN
            SET NEW.gender = 'M';
        ELSEIF NEW.gender = 'nữ' THEN
            SET NEW.gender = 'F';
        ELSEIF NEW.gender = 'chưa xác định' THEN
            SET NEW.gender = 'U';
        END IF;
    END$$
DELIMITER ;

INSERT INTO account_copy(email, user_name, full_name, gender, department_id, position_id, create_date)
VALUES ('dai.vu@gmail.com', 'dai.vu', 'Vũ Văn Đại', 'nam', 1, 1, '2021-11-01');
INSERT INTO account_copy(email, user_name, full_name, gender, department_id, position_id, create_date)
VALUES ('hue.nguyen@gmail.com', 'hue.nguyen', 'Nguyễn Thị Huệ', 'nữ', 1, 1, '2021-11-01');
INSERT INTO account_copy(email, user_name, full_name, gender, department_id, position_id, create_date)
VALUES ('trang.do@gmail.com', 'trang.do', 'Đỗ Thu Trang', 'chưa xác định', 1, 1, '2021-11-01');
SELECT * FROM account_copy;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS trg_delete_exam_limit_2d_ago;
DELIMITER $$
CREATE TRIGGER trg_delete_exam_limit_2d_ago
BEFORE DELETE ON exam
FOR EACH ROW
    BEGIN
        IF OLD.create_date > DATE_SUB(curdate(), INTERVAL 2 DAY) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Không thể xóa bài thi mới tạo được 2 ngày.';
        END IF;
    END$$
DELIMITER ;

INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date)
VALUES  ('T1', 'Bài thi test', 1, 15, 1, '2021-10-31');
DELETE FROM exam WHERE `code` = 'T1';

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS trg_delete_question_limit;
DELIMITER $$
CREATE TRIGGER trg_delete_question_limit
BEFORE DELETE ON question                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
FOR EACH ROW
    BEGIN
        DECLARE examCount INT;
        SELECT COUNT(exam_id) INTO examCount -- Đếm số bài thi sử dụng câu hỏi muốn xóa
        FROM exam_question
        WHERE question_id = OLD.question_id;
        IF examCount <> 0 THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Không thể delete câu hỏi nằm trong một hoặc nhiều bài thi.';
        END IF;
    END$$
DELIMITER ;

DROP TRIGGER IF EXISTS trg_update_question_limit;
DELIMITER $$
CREATE TRIGGER trg_update_question_limit
BEFORE UPDATE ON question                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
FOR EACH ROW
    BEGIN
        DECLARE examCount INT;
        SELECT COUNT(exam_id) INTO examCount -- Đếm số bài thi sử dụng câu hỏi muốn update
        FROM exam_question
        WHERE question_id = OLD.question_id;
        IF examCount <> 0 THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Không thể update câu hỏi nằm trong một hoặc nhiều bài thi.';
        END IF;
    END$$
DELIMITER ;

SELECT * FROM exam_question;
SELECT * FROM question;
DELETE FROM question WHERE question_id = 40;
UPDATE question
SET question_id = 40
WHERE question_id = 4;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT * FROM exam; 
SELECT
    exam_id,
    `code`,
    title,
    category_id,
    CASE
        WHEN duration <= 30 THEN 'Short time'
        WHEN duration > 30 AND duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS duration,
    creator_id,
    create_date
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT
    g.group_name,
    COUNT(a.account_id) AS 'Số lượng account',
    CASE
        WHEN COUNT(a.account_id) <= 5 THEN 'few'
        WHEN COUNT(a.account_id) <= 20 AND COUNT(a.account_id) > 5 THEN 'normal'
        WHEN COUNT(a.account_id) > 20 THEN 'higher'
    END AS the_number_user_amount
FROM `group` g
LEFT JOIN group_account a ON g.group_id = a.group_id
GROUP BY g.group_id;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT
    d.department_name,
    CASE
        WHEN COUNT(a.account_id) = 0 THEN 'Không có User'
        ELSE COUNT(a.account_id)
    END AS 'Số lượng user'
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id;