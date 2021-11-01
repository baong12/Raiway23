-- Question 1:
-- Tối ưu lại assignment trước
-- Question 2:
-- Thêm các constraint vào assignment trước
DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE testing_system;

-- Table 1:Department
--  DepartmentID: định danh của phòng ban (auto increment)
--  DepartmentName: tên đầy đủ của phòng ban (VD: sale, marketing, …)
DROP TABLE IF EXISTS department;
CREATE TABLE department(
    department_id       TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name     VARCHAR(30) CHAR SET utf8mb4 NOT NULL UNIQUE
);
INSERT INTO department(department_name)
VALUES  
        ('Waiting room'),
        ('Marketing'),
        ('Sales'),
        ('Quản trị'),
        ('Tài chính'),
        ('Nhân sự'),
        ('Kỹ thuật'),
        ('Kinh doanh'),
        ('Dự án');

-- Table 2: Position
--  PositionID: định danh của chức vụ (auto increment)
--  PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
    position_id     TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    position_name   ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
INSERT INTO `position`(position_name)
VALUES  ('Dev'),
        ('Test'),
        ('Scrum Master'),
        ('PM');

-- Table 3: Account
--  AccountID: định danh của User (auto increment)
--  Email:
--  Username:
--  FullName:
--  DepartmentID: phòng ban của user trong hệ thống
--  PositionID: chức vụ của User
--  CreateDate: ngày tạo tài khoản
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    account_id      SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(50) UNIQUE NOT NULL,
    user_name       VARCHAR(20) UNIQUE NOT NULL UNIQUE,
    full_name       VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    department_id   TINYINT NOT NULL,
    position_id     TINYINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (position_id) REFERENCES `position`(position_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)
VALUES  ('tommy.teo@gmail.com',         'tommy',        'Ngô Hoàng Sơn',        1, 1, '2010-10-18'),
        ('jimmy.nguyen@gmail.com',      'jimmy',        'Nguyễn Thành Long',    2, 2, '2010-12-20'),
        ('tony.stark@gmail.com',        'tonystark',    'Vũ Thái Huy',          3, 3, '2021-10-16'),
        ('steve.rogers@gmail.com',      'steve',        'Trần Mạnh Duy',        4, 4, '2021-10-15'),
        ('steven.strange@gmail.com',    'drstrange',    'Huỳnh Quang Ngọc',     5, 4, '2021-10-14'),
        ('hao.doann@gmail.com',         'haodoan',      'Phạm Hồng Ngọc',       5, 3, '2021-10-15'),
        ('toan.nguyen@gmail.com',       'nvt9',         'Trịnh Thanh Thủy',     3, 1, '2021-10-20'),
        ('phuong.nguyen@gmail.com',     'ncp10',        'Phí Hương Giang',      3, 1, '2021-10-20'),
        ('hai.nguyen@gmail.com',        'qhai',         'Nguyễn Anh Thư',       3, 1, '2021-10-20'),
        ('nguyenvanthe@gmail.com',        'nvthe',         'Nguyễn Văn Thế',       3, 3, '2021-10-20'),
        ('doan.hau@gmail.com',          'dh5',          'Hồ Phương Anh',        2, 2, '2021-10-20');

-- Table 4: Group
--  GroupID: định danh của nhóm (auto increment)
--  GroupName: tên nhóm
--  CreatorID: id của người tạo group
--  CreateDate: ngày tạo group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
    group_id        SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    group_name      VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO `group`(group_name, creator_id, create_date)
VALUES  ('Railway 1', 1, '2019-12-14'),
        ('Railway 2', 2, '2019-12-13'),
        ('Railway 3', 4, '2019-12-12'),
        ('Railway 4', 3, '2019-12-21'),
        ('Railway 5', 3, '2019-12-21'),
        ('Railway 6', 6, '2019-12-21'),
        ('Railway 7', 3, '2019-12-21'),
        ('Railway 8', 7, '2019-12-21'),
        ('Railway 9', 5, '2019-12-20');

-- Table 5: GroupAccount
--  GroupID: định danh của nhóm
--  AccountID: định danh của User
--  JoinDate: Ngày user tham gia vào nhóm
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
    group_id    SMALLINT NOT NULL, -- quan hệ nhiều nhiều
    account_id  SMALLINT NOT NULL, -- quan hệ nhiều nhiều
    join_date   DATE,
    PRIMARY KEY (group_id, account_id), -- double khóa chính
    FOREIGN KEY (group_id) REFERENCES `group`(group_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (account_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO group_account(group_id, account_id, join_date)
VALUES  (1, 1, '2021-10-14'),
        (1, 2, '2021-10-13'),
        (1, 5, '2021-10-13'),
        (2, 2, '2021-10-13'),
        (2, 5, '2021-10-13'),
        (2, 6, '2021-10-13'),
        (2, 8, '2021-10-13'),
        (3, 4, '2021-10-12'),
        (3, 6, '2021-10-11'),
        (4, 5, '2021-10-11'),
        (4, 6, '2021-10-11'),
        (4, 3, '2021-10-11'),
        (4, 8, '2021-10-11'),
        (4, 9, '2021-10-11'),
        (4, 10, '2021-10-11'),
        (5, 5, '2021-10-10');
-- SELECT * FROM group_account;

-- Table 6: TypeQuestion
--  TypeID: định danh của loại câu hỏi (auto increment)
--  TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
    type_id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type_name   ENUM('Essay', 'Multiple-Choice')
);
INSERT INTO type_question(type_name)
VALUES  ('Essay'),
        ('Multiple-Choice');

-- Table 7: CategoryQuestion
--  CategoryID: định danh của chủ đề câu hỏi (auto increment)
--  CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby,…)
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name   VARCHAR(50) CHAR SET utf8mb4 NOT NULL UNIQUE
);
INSERT INTO category_question(category_name)
VALUES  ('Java'),
        ('.NET'),
        ('SQL'),
        ('Postman'),
        ('JavaScript'),
        ('Ruby');

-- Table 8: Question
--  QuestionID: định danh của câu hỏi (auto increment)
--  Content: nội dung của câu hỏi
--  CategoryID: định danh của chủ đề câu hỏi
--  TypeID: định danh của loại câu hỏi
--  CreatorID: id của người tạo câu hỏi
--  CreateDate: ngày tạo câu hỏi
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content         VARCHAR(1000) CHAR SET utf8mb4 NOT NULL,
    category_id     INT NOT NULL,
    type_id         INT NOT NULL,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO question(content, category_id, type_id, creator_id, create_date)
VALUES  ('Java là gì', 1, 1, 1, '2021-09-19'),
        ('.Net là gì', 2, 2, 2, '2021-10-19'),
        ('SQL là gì', 3, 1, 3, '2021-10-19'),
        ('SQL là gì vậy', 3, 1, 3, '2021-10-19'),
        ('SQL là gì thế', 3, 1, 3, '2021-10-19'),
        ('Postman là gì', 4, 2, 4, '2020-10-19'),
        ('Ruby là gì', 5, 1, 5, '2021-10-19'),
        ('JavaScript là gì', 5, 1, 5, '2021-10-19'),
        ('a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c',
        5, 1, 5, '2021-10-19'),
        ('123 a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c 
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c
        a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c a b c',
        5, 1, 5, '2021-10-19'),
        ('Câu hỏi số 6: Đáp án là gì?', 2, 1, 10, '2021-10-20');

-- Table 9: Answer
--  AnswerID: định danh của câu trả lời (auto increment)
--  Content: nội dung của câu trả lời
--  QuestionID: định danh của câu hỏi
--  isCorrect: câu trả lời này đúng hay sai
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content         VARCHAR(500) CHAR SET utf8mb4 NOT NULL,
    question_id     INT NOT NULL,
    is_correct      BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);
INSERT INTO answer(content, question_id, is_correct)
VALUES  ('Là ngôn ngữ lập trình', 1, TRUE),
        ('Không là ngôn ngữ lập trình', 2, FALSE),
        ('Là ngôn ngữ lập trình', 1, TRUE),
        ('Không là ngôn ngữ lập trình', 2, FALSE),
        ('Là ngôn ngữ lập trình', 3, TRUE);

-- Table 10: Exam
--  ExamID: định danh của đề thi (auto increment)
--  Code: mã đề thi
--  Title: tiêu đề của đề thi
--  CategoryID: định danh của chủ đề thi
--  Duration: thời gian thi
--  CreatorID: id của người tạo đề thi
--  CreateDate: ngày tạo đề thi
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
    exam_id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code`          VARCHAR(50) NOT NULL UNIQUE,
    title           VARCHAR(200) CHAR SET utf8mb4 NOT NULL,
    category_id     INT NOT NULL,
    duration        INT NOT NULL,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date)
VALUES  ('A1', 'Bài thi A1', 1, 15, 1, '2016-10-19'),
        ('A2', 'Bài thi A2', 1, 30, 1, '2017-10-19'),
        ('A3', 'Bài thi A3', 1, 30, 1, '2017-10-19'),
        ('A4', 'Bài thi A4', 2, 30, 1, '2018-10-19'),
        ('A5', 'Bài thi A5', 2, 30, 2, '2018-10-19'),
        ('A6', 'Bài thi A6', 2, 30, 2, '2019-10-19'),
        ('B2', 'Bài thi B2', 2, 30, 2, '2019-10-19'),
        ('C3', 'Bài thi C3', 3, 45, 2, '2019-10-19'),
        ('D4', 'Bài thi D4', 4, 60, 3, '2019-10-19'),
        ('E5', 'Bài thi E5', 5, 75, 3, '2019-10-19'),
        ('E6', 'Bài thi E6', 5, 75, 3, '2019-10-19'),
        ('E7', 'Bài thi E7', 5, 75, 4, '2021-10-19'),
        ('E8', 'Bài thi E8', 5, 75, 4, '2021-10-19'),
        ('E9', 'Bài thi E9', 5, 75, 5, '2021-10-19'),
        ('D5', 'Bài thi D5', 5, 75, 6, '2021-10-19');

-- Table 11: ExamQuestion
--  ExamID: định danh của đề thi
--  QuestionID: định danh của câu hỏi
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id         INT NOT NULL,
    question_id     INT NOT NULL,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO exam_question(exam_id, question_id)
VALUES  (1, 2),
        (2, 3),
        (3, 4),
        (4, 6),
        (6, 5),
        (4, 5),
        (7, 5),
        (9, 4),
        (5, 1);
