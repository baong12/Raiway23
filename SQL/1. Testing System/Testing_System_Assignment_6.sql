USE testing_system;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DESCRIBE department;
DROP PROCEDURE IF EXISTS sp_nhap_dept_in_acc;

DELIMITER $$
CREATE PROCEDURE sp_nhap_dept_in_acc(IN tenPhongBan VARCHAR(30) CHAR SET utf8mb4)
    BEGIN
        SELECT a.full_name
        FROM `account` a
        JOIN department d ON d.department_id = a.department_id
        WHERE d.department_name = tenPhongBan;
    END$$
DELIMITER ;

CALL sp_nhap_dept_in_acc('Quản trị');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_in_soluong_acc_moi_gr;

DELIMITER $$
CREATE PROCEDURE sp_in_soluong_acc_moi_gr()
    BEGIN
        SELECT g.group_name, COUNT(ga.account_id) AS "Số lượng account"
        FROM `group` g
        LEFT JOIN group_account ga ON g.group_id = ga.group_id
        GROUP BY g.group_id;
    END$$
DELIMITER ;

CALL sp_in_soluong_acc_moi_gr();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DESCRIBE question;
DROP PROCEDURE IF EXISTS sp_thongke_soluong_question_moi_type_thismonth;

DELIMITER $$
CREATE PROCEDURE sp_thongke_soluong_question_moi_type_thismonth()
    BEGIN
        SELECT t.type_name, COUNT(question_id) AS "Số lượng question"
        FROM type_question t
        LEFT JOIN question q ON q.type_id = t.type_id
        WHERE MONTH(q.create_date) = MONTH(current_date())
            AND YEAR(q.create_date) = YEAR(current_date())
        GROUP BY t.type_id;
    END$$
DELIMITER ;

CALL sp_thongke_soluong_question_moi_type_thismonth();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_in_typeid_max_cauhoi;

DELIMITER $$
CREATE PROCEDURE sp_in_typeid_max_cauhoi(OUT typeid_max_cauhoi INT)
    BEGIN
        SELECT type_id INTO typeid_max_cauhoi
        FROM question
        GROUP BY type_id
        HAVING COUNT(question_id) = (
            SELECT MAX(question_count)
            FROM (
                SELECT COUNT(question_id) AS question_count
                FROM question
                GROUP BY type_id
            ) AS t1
        );
    END$$
DELIMITER ;

CALL sp_in_typeid_max_cauhoi(@type_max_cauhoi);
SELECT @ten_max_cauhoi;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
CALL sp_in_typeid_max_cauhoi(@type_max_cauhoi);
SELECT type_name
FROM type_question
WHERE type_id = @type_max_cauhoi;

-- Tạo stored procedure
DROP PROCEDURE IF EXISTS sp_get_typename_max_question;
DELIMITER $$
CREATE PROCEDURE sp_get_typename_max_question()
    BEGIN
        DECLARE typeId INT;
        CALL sp_in_typeid_max_cauhoi(typeId);
        SELECT type_name FROM type_question WHERE type_id = typeId;
    END$$
DELIMITER ;

CALL sp_get_typename_max_question();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào

-- DROP PROCEDURE IF EXISTS sp_tim_gr_hoac_user;
-- DELIMITER $$
-- CREATE PROCEDURE sp_tim_gr_hoac_user(IN searchString VARCHAR(50) CHAR SET utf8mb4)
--     BEGIN
--         SELECT g.group_name, a.user_name, searchString
--         FROM `group` g
--             JOIN group_account ga ON g.group_id = ga.group_id
--             JOIN `account` a ON a.account_id = ga.account_id
--         WHERE g.group_name LIKE CONCAT('%', searchString , '%') COLLATE utf8mb4_unicode_ci
--             OR a.user_name LIKE CONCAT('%', searchString , '%') COLLATE utf8mb4_unicode_ci;
--     END$$
-- DELIMITER ;

DROP PROCEDURE IF EXISTS sp_tim_gr_hoac_user;
DELIMITER $$
CREATE PROCEDURE sp_tim_gr_hoac_user(IN searchString VARCHAR(50))
    BEGIN
        SELECT group_name COLLATE utf8mb4_unicode_ci AS 'Search result'
        FROM `group`
        WHERE group_name COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', searchString , '%')
            UNION ALL
        SELECT user_name COLLATE utf8mb4_unicode_ci AS 'Search result'
        FROM `account`
        WHERE user_name COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', searchString , '%');
    END$$
DELIMITER ;

CALL sp_tim_gr_hoac_user('rail');
CALL sp_tim_gr_hoac_user('nvthe');
CALL sp_tim_gr_hoac_user('r');

DESCRIBE `account`;
DESCRIBE `group_account`;

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_nhap_tt_tao_tk;
DELIMITER $$
CREATE PROCEDURE sp_nhap_tt_tao_tk(
    IN fullName VARCHAR(50) CHAR SET utf8mb4,
    IN userEmail VARCHAR(50)
)
    BEGIN
        DECLARE userName VARCHAR(50) DEFAULT SUBSTRING_INDEX(userEmail, '@', 1);
        DECLARE departmentId TINYINT UNSIGNED DEFAULT 1;
        DECLARE positionId TINYINT UNSIGNED DEFAULT 1;
        DECLARE createDate DATE DEFAULT curdate();
        
        INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)
        VALUES (userEmail, userName, fullName, departmentId, positionId, createDate);
        
        SELECT  a.account_id, a.email, a.user_name, a.full_name, d.department_name, p.position_name, a.create_date
        FROM `account` a
        JOIN department d ON d.department_id = a.department_id
        JOIN `position` p ON p.position_id = a.position_id
        WHERE email = userEmail;
    END$$
DELIMITER ;

CALL sp_nhap_tt_tao_tk('Nguyễn Kim Bảo', 'bao.nguyen@gmail.com');
DELETE FROM `account` WHERE email = 'bao.nguyen@gmail.com';
DELETE FROM `account` WHERE account_id = (
    SELECT account_id FROM `account`
);


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
-- DROP PROCEDURE IF EXISTS sp_thongke_content_maxlength;
-- DELIMITER $$
-- CREATE PROCEDURE sp_thongke_content_maxlength(IN typeQuestion ENUM('Essay', 'Multiple-Choice'))
--     BEGIN
--         SELECT t.type_name, q.content, length(q.content) AS 'Độ dài content'
--         FROM type_question t
--         JOIN question q ON q.type_id = t.type_id
--         WHERE length(q.content) = (
--             SELECT MAX(length(q.content))
--             FROM question q
--             JOIN type_question t ON t.type_id = q.type_id
--             WHERE t.type_name = typeQuestion
--         );
--     END$$
-- DELIMITER ;

DROP PROCEDURE IF EXISTS sp_thongke_content_maxlength;
DELIMITER $$
CREATE PROCEDURE sp_thongke_content_maxlength(IN typeQuestion ENUM('Essay', 'Multiple-Choice'))
    BEGIN
        SELECT t.type_name, q.content, length(q.content) AS 'Độ dài content'
        FROM type_question t
        JOIN question q ON q.type_id = t.type_id
        WHERE length(q.content) = (
            SELECT MAX(length(q.content))
            FROM question q
            JOIN type_question t ON t.type_id = q.type_id
            WHERE t.type_name = typeQuestion
        );
    END$$
DELIMITER ;

CALL sp_thongke_content_maxlength('Essay');
CALL sp_thongke_content_maxlength('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_xoa_exam_theo_id;
DELIMITER $$
CREATE PROCEDURE sp_xoa_exam_theo_id(IN examId INT)
    BEGIN
        DELETE FROM exam
        WHERE exam_id = examId;
    END$$
DELIMITER ;

CALL sp_xoa_exam_theo_id(10);
SELECT * FROM exam;

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
SELECT * FROM exam_question;

DROP PROCEDURE IF EXISTS sp_xoa_exam_3y_ago;
DELIMITER $$
CREATE PROCEDURE sp_xoa_exam_3y_ago()
    BEGIN
        DECLARE examQuestionRecordCount INT;
        DECLARE examRecordCount INT;
        DECLARE examId INT;
        DECLARE loopCount INT;
        
        SET examQuestionRecordCount = (
            SELECT COUNT(*) FROM exam_question
        );
        
        SELECT COUNT(*) INTO loopCount
        FROM exam
        WHERE create_date < date_sub(curdate(), INTERVAL 3 YEAR);
        
        SELECT loopCount INTO examRecordCount;
        
        WHILE loopCount > 0 DO
            SET examId = (
                SELECT exam_id
                FROM exam
                WHERE create_date < date_sub(curdate(), INTERVAL 3 YEAR)
                LIMIT 1
            );        
            CALL sp_xoa_exam_theo_id(examId);
            SET loopCount = loopCount - 1;
        END WHILE;
        
        SELECT CONCAT(examRecordCount, ', ', examQuestionRecordCount - COUNT(*))
            AS 'số lượng record đã remove (exam, exam_question)'
        FROM exam_question;
    END$$
DELIMITER ;

CALL sp_xoa_exam_3y_ago();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_xoa_dp_set_default;
DELIMITER $$
CREATE PROCEDURE sp_xoa_dp_set_default(IN depName VARCHAR(30) CHAR SET utf8mb4)
    BEGIN 
        -- Chuyển nhân viên thuộc phòng ban depName sang Waititng room
        UPDATE `account`
        -- lay department_id cua phong 'Waiting room'
        SET department_id = (
            SELECT department_id
            FROM department
            WHERE department_name = 'Waiting room'
        )
        -- lay department_id cua phong ban duoc nhap vao
        WHERE department_id = (
            SELECT department_id
            FROM department
            WHERE department_name = depName
        );
        
        -- Xoá phòng ban
        DELETE FROM department
        WHERE department_name = depName;
    END$$
DELIMITER ;

SELECT * FROM `account` a JOIN department d ON d.department_id = a.department_id;
SELECT * FROM department;
CALL sp_xoa_dp_set_default('Sales');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay
DROP PROCEDURE IF EXISTS sp_thongke_cauhoi_monthly_curyear;
DELIMITER $$
CREATE PROCEDURE sp_thongke_cauhoi_monthly_curyear()
    BEGIN
        WITH
            all_months AS (
                SELECT 1 AS 'month'
                UNION
                SELECT 2 AS 'month'
                UNION
                SELECT 3 AS 'month'
                UNION
                SELECT 4 AS 'month'
                UNION
                SELECT 5 AS 'month'
                UNION
                SELECT 6 AS 'month'
                UNION
                SELECT 7 AS 'month'
                UNION
                SELECT 8 AS 'month'
                UNION
                SELECT 9 AS 'month'
                UNION
                SELECT 10 AS 'month'
                UNION
                SELECT 11 AS 'month'
                UNION
                SELECT 12 AS 'month'
            ),
            question_curyear AS (
                SELECT * FROM question WHERE YEAR(create_date) = YEAR(CURDATE())
            )
        SELECT am.`month`, COUNT(q.question_id) AS 'Số câu hỏi trong tháng'
        FROM all_months am
        LEFT JOIN question_curyear q ON MONTH(q.create_date) = am.`month`
        -- WHERE YEAR(create_date) = YEAR(current_date())
        GROUP BY am.`month`;
    END$$
DELIMITER ;

CALL sp_thongke_cauhoi_monthly_curyear();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")
DROP PROCEDURE IF EXISTS sp_thongke_cauhoi_monthly_last6m;
DELIMITER $$
CREATE PROCEDURE sp_thongke_cauhoi_monthly_last6m()
    BEGIN
        DROP TEMPORARY TABLE IF EXISTS tbl_last_6m;
        CREATE TEMPORARY TABLE tbl_last_6m (
            thang TINYINT
        );
        INSERT INTO tbl_last_6m(thang) VALUES 
            (MONTH(DATE_SUB(curdate(), INTERVAL 5 MONTH))),
            (MONTH(DATE_SUB(curdate(), INTERVAL 4 MONTH))),
            (MONTH(DATE_SUB(curdate(), INTERVAL 3 MONTH))),
            (MONTH(DATE_SUB(curdate(), INTERVAL 2 MONTH))),
            (MONTH(DATE_SUB(curdate(), INTERVAL 1 MONTH))),
            (MONTH(curdate()));
        
        SELECT l6.thang, COUNT(q.question_id) AS 'Số câu hỏi trong tháng'
        FROM tbl_last_6m l6
        LEFT JOIN (
            SELECT * FROM question
            WHERE create_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
            AND create_date <= curdate()
        ) AS q ON l6.thang = MONTH(q.create_date)
        GROUP BY l6.thang;
    END$$
DELIMITER ;

CALL sp_thongke_cauhoi_monthly_last6m();