USE testing_system;

-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT *
FROM `account` acc
LEFT JOIN department dep ON acc.department_id = dep.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `account`
WHERE create_date > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT *
FROM `account` acc
JOIN `position` pos ON acc.position_id = pos.position_id
WHERE pos.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT dep.department_name, COUNT(acc.department_id) AS employee_count
FROM department dep
RIGHT JOIN `account` acc ON dep.department_id = acc.department_id
GROUP BY dep.department_id
HAVING COUNT(dep.department_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.*, COUNT(eq.exam_id) AS question_count
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id
HAVING question_count = (
    SELECT MAX(question_count) AS max_count
    FROM (
        SELECT COUNT(eq.exam_id) as question_count
        FROM question q
        LEFT JOIN exam_question eq ON q.question_id = eq.question_id
        GROUP BY q.question_id
    ) AS t1
);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT * FROM category_question;
SELECT *, COUNT(q.question_id) as question_count
FROM category_question ca
LEFT JOIN question q ON ca.category_id = q.category_id
GROUP BY ca.category_id;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT * FROM exam_question;
SELECT *, COUNT(eq.exam_id) as exam_count
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT * FROM answer;
SELECT q.*, COUNT(a.answer_id) AS answer_count
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
GROUP BY a.question_id
HAVING answer_count = (
    SELECT MAX(answer_count)
    FROM (
        SELECT COUNT(a.answer_id) AS answer_count
        FROM question q
        LEFT JOIN answer a ON q.question_id = a.question_id
        GROUP BY a.question_id
    ) AS t1
);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT * FROM group_account;
SELECT g.*, COUNT(ga.account_id) as account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT * FROM `account`;
SELECT p.position_name, COUNT(a.account_id) as account_count
FROM `position` p
LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY a.position_id
HAVING account_count = (
    SELECT MIN(account_count)
    FROM (
        SELECT COUNT(a.account_id) as account_count
        FROM `position` p
        LEFT JOIN `account` a ON p.position_id = a.position_id
        GROUP BY a.position_id
    ) AS t1
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev,
-- test, scrum master, PM
SELECT * FROM `account`;

SELECT department_name, position_name, COUNT(position_name)
FROM (
    SELECT a.*, d.department_name, p.position_name
    FROM `account` a
    JOIN department d ON d.department_id = a.department_id
    JOIN `position` p ON p.position_id = a.position_id
    GROUP BY a.account_id
) AS t1
GROUP BY position_name;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT * FROM question;
SELECT q.question_id, c.category_name, t.type_name, a.full_name AS creator_name, q.create_date
FROM question q
LEFT JOIN category_question c ON q.category_id = c.category_id
LEFT JOIN type_question t ON q.type_id = t.type_id
LEFT JOIN `account` a ON q.creator_id = a.account_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
-- Question 14:Lấy ra group không có account nào
-- Question 15: Lấy ra group không có account nào
-- Question 16: Lấy ra question không có answer nào