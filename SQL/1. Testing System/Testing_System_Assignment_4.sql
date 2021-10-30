USE testing_system;

-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT acc.full_name, dep.*
FROM `account` acc
JOIN department dep ON acc.department_id = dep.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `account`
WHERE create_date > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT acc.full_name
FROM `account` acc
JOIN `position` pos ON acc.position_id = pos.position_id
WHERE pos.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT dep.department_name
FROM department dep
JOIN `account` acc ON dep.department_id = acc.department_id
GROUP BY dep.department_id
HAVING COUNT(acc.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT * FROM question;
SELECT * FROM exam_question;

SELECT q.content, COUNT(eq.exam_id) AS 'Số bài thi'
FROM question q
JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id
HAVING COUNT(eq.exam_id) = (
    SELECT MAX(exam_count)
    FROM (
        SELECT COUNT(exam_id) AS exam_count
        FROM exam_question
        GROUP BY question_id
    ) AS　t2
);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT * FROM category_question;

SELECT ca.category_name, COUNT(q.question_id) as question_count
FROM category_question ca
LEFT JOIN question q ON ca.category_id = q.category_id
GROUP BY ca.category_id;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT * FROM exam_question;

SELECT q.content, COUNT(eq.exam_id) as exam_count
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT * FROM answer;

SELECT q.content, COUNT(a.answer_id) AS 'Số câu trả lời'
FROM question q
JOIN answer a ON q.question_id = a.question_id
GROUP BY a.question_id
HAVING COUNT(a.answer_id) = (
    SELECT MAX(answer_count)
    FROM (
        SELECT question_id, COUNT(answer_id) AS answer_count
        FROM answer
        GROUP BY question_id
    ) AS t1
);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT * FROM group_account;

SELECT g.group_name, COUNT(ga.account_id) as account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT * FROM `account`;

SELECT p.position_name, COUNT(a.account_id) AS 'Số lượng account'
FROM `position` p
LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id
HAVING COUNT(a.account_id) = (
    SELECT MIN(account_count) AS min_account
    FROM (
        SELECT p.position_id, COUNT(a.account_id) AS account_count
        FROM `position` p
        LEFT JOIN `account` a ON p.position_id = a.position_id
        GROUP BY p.position_id
    ) AS t1
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT * FROM `account`;

SELECT d.department_name, p.position_name, COUNT(a.position_id) AS 'Số lượng nhân viên'
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
LEFT JOIN `position` p ON p.position_id = a.position_id
GROUP BY d.department_id, p.position_id;

-- Chưa đúng yêu cầu nhưng mà tham khảo :v ↓
SELECT tmp.department_name, GROUP_CONCAT(tmp.cnt_position) 'Danh sach vi tri'
FROM (
    SELECT dp.*, CONCAT(COUNT(ac.position_id), ' ', p.position_name) cnt_position
    FROM department dp
    LEFT JOIN `account` ac ON dp.department_id = ac.department_id
    LEFT JOIN `position` p ON ac.position_id = p.position_id
    GROUP BY dp.department_id, p.position_id
) AS tmp
GROUP BY tmp.department_id;
-- Cre: Tươi Nguyễn

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT * FROM question;
SELECT q.question_id, 
    c.category_name,
    t.type_name,
    a.full_name AS creator_name,
    ans.content AS 'answer_content',
    q.create_date
FROM question q
LEFT JOIN category_question c ON q.category_id = c.category_id
LEFT JOIN type_question t ON q.type_id = t.type_id
LEFT JOIN `account` a ON q.creator_id = a.account_id
LEFT JOIN answer ans ON ans.question_id = q.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT t.type_name, COUNT(q.question_id) AS question_count
FROM type_question t
LEFT JOIN question q ON q.type_id = t.type_id
GROUP BY t.type_id;

-- Question 14:Lấy ra group không có account nào
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING account_count = 0;

-- Question 15: Lấy ra group không có account nào
-- (Cách 2: left excluding join)
SELECT g.group_name
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.group_id IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT * FROM question;
SELECT * FROM answer;
SELECT q.*, COUNT(a.answer_id) AS answer_count
FROM question q
LEFT JOIN answer a ON a.question_id = q.question_id
GROUP BY q.question_id
HAVING answer_count = 0;

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT * FROM group_account;
SELECT ga.group_id, a.user_name
FROM group_account ga
JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 1;

-- b) Lấy các account thuộc nhóm thứ 2
SELECT ga.group_id, a.user_name
FROM group_account ga
JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 2;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT ga.group_id, a.user_name
FROM group_account ga
JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 1
    UNION
SELECT ga.group_id, a.user_name
FROM group_account ga
JOIN `account` a ON ga.account_id = a.account_id
WHERE group_id = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING account_count > 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING account_count < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING account_count > 5
    UNION ALL
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING account_count < 7