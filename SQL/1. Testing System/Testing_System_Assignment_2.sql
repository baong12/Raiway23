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
    department_id       SMALLINT AUTO_INCREMENT PRIMARY KEY,
    department_name     VARCHAR(50) CHAR SET utf8mb4 NOT NULL
);

-- Table 2: Position
--  PositionID: định danh của chức vụ (auto increment)
--  PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
    position_id     SMALLINT AUTO_INCREMENT PRIMARY KEY,
    position_name   ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);

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
    account_id      SMALLINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(50) UNIQUE NOT NULL,
    user_name       VARCHAR(50) UNIQUE NOT NULL,
    full_name       VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    department_id   SMALLINT NOT NULL,
    position_id     SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id)
);

-- Table 4: Group
--  GroupID: định danh của nhóm (auto increment)
--  GroupName: tên nhóm
--  CreatorID: id của người tạo group
--  CreateDate: ngày tạo group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
    group_id        SMALLINT AUTO_INCREMENT PRIMARY KEY,
    group_name      VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 5: GroupAccount
--  GroupID: định danh của nhóm
--  AccountID: định danh của User
--  JoinDate: Ngày user tham gia vào nhóm
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
    group_id    SMALLINT NOT NULL,
    account_id  SMALLINT NOT NULL,
    join_date   DATE,
    FOREIGN KEY(group_id) REFERENCES `group`(group_id),
    FOREIGN KEY(account_id) REFERENCES `account`(account_id)
);

-- Table 6: TypeQuestion
--  TypeID: định danh của loại câu hỏi (auto increment)
--  TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
    type_id     INT AUTO_INCREMENT PRIMARY KEY,
    type_name   ENUM('Essay', 'Multiple-Choice')
);

-- Table 7: CategoryQuestion
--  CategoryID: định danh của chủ đề câu hỏi (auto increment)
--  CategoryName: tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby,…)
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id     INT AUTO_INCREMENT PRIMARY KEY,
    category_name   VARCHAR(50) NOT NULL
);

-- Table 8: Question
--  QuestionID: định danh của câu hỏi (auto increment)
--  Content: nội dung của câu hỏi
--  CategoryID: định danh của chủ đề câu hỏi
--  TypeID: định danh của loại câu hỏi
--  CreatorID: id của người tạo câu hỏi
--  CreateDate: ngày tạo câu hỏi
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id     INT AUTO_INCREMENT PRIMARY KEY,
    content         VARCHAR(500) CHAR SET utf8mb4 NOT NULL,
    category_id     INT NOT NULL,
    type_id         INT NOT NULL,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 9: Answer
--  AnswerID: định danh của câu trả lời (auto increment)
--  Content: nội dung của câu trả lời
--  QuestionID: định danh của câu hỏi
--  isCorrect: câu trả lời này đúng hay sai
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answer_id       INT AUTO_INCREMENT PRIMARY KEY,
    content         VARCHAR(500) CHAR SET utf8mb4 NOT NULL,
    question_id     INT NOT NULL,
    is_correct      BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

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
    exam_id         INT AUTO_INCREMENT PRIMARY KEY,
    `code`          VARCHAR(50) NOT NULL,
    title           VARCHAR(200) CHAR SET utf8mb4 NOT NULL,
    category_id     INT NOT NULL,
    duration        INT NOT NULL,
    creator_id      SMALLINT NOT NULL,
    create_date     DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 11: ExamQuestion
--  ExamID: định danh của đề thi
--  QuestionID: định danh của câu hỏi
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
    exam_id         INT NOT NULL,
    question_id     INT NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

-- Question 3: Chuẩn bị data cho bài 3
INSERT INTO department(department_name)
VALUES  ('Marketing'),
        ('Sales'),
        ('Quản trị'),
        ('Tài chính'),
        ('Nhân sự'),
        ('Kỹ thuật');

INSERT INTO `position`(position_name)
VALUES  ('Dev'),
        ('Test'),
        ('Scrum Master'),
        ('PM');

INSERT INTO `account`(email, user_name, full_name, department_id, position_id, create_date)
VALUES  ('tommy.teo@gmail.com', 'tommy', 'Tommy Tèo', 1, 1, '2021-10-18'),
        ('jimmy.nguyen@gmail.com', 'jimmy', 'Jimmy Nguyễn', 2, 2, '2021-10-17'),
        ('tony.stark@gmail.com', 'tonystark', 'Tony Stark', 3, 3, '2021-10-16'),
        ('steve.rogers@gmail.com', 'steve', 'Steve Rogers', 4, 4, '2021-10-15'),
        ('steven.strange@gmail.com', 'drstrange', 'Steven Strange', 5, 4, '2021-10-14');

INSERT INTO `group`(group_name, creator_id, create_date)
VALUES  ('Railway 1', 1, '2021-10-14'),
        ('Railway 2', 2, '2021-10-13'),
        ('Railway 3', 4, '2021-10-12'),
        ('Railway 4', 3, '2021-10-11'),
        ('Railway 5', 5, '2021-10-10');
        
INSERT INTO group_account(group_id, account_id, join_date)
VALUES  (1, 1, '2021-10-14'),
        (2, 2, '2021-10-13'),
        (3, 4, '2021-10-12'),
        (4, 3, '2021-10-11'),
        (5, 5, '2021-10-10');
        
INSERT INTO type_question(type_name)
VALUES  ('Essay'),
        ('Multiple-Choice');
        
INSERT INTO category_question(category_name)
VALUES  ('Java'),
        ('.NET'),
        ('SQL'),
        ('Postman'),
        ('Ruby');
        
INSERT INTO question(content, category_id, type_id, creator_id, create_date)
VALUES  ('Java là gì', 1, 1, 1, '2021-10-19'),
        ('.Net là gì', 2, 2, 2, '2021-10-19'),
        ('SQL là gì', 3, 1, 3, '2021-10-19'),
        ('Postman là gì', 4, 2, 4, '2021-10-19'),
        ('Ruby là gì', 5, 1, 5, '2021-10-19');
        
INSERT INTO answer(content, question_id, is_correct)
VALUES  ('Là ngôn ngữ lập trình', 1, true),
        ('Không là ngôn ngữ lập trình', 1, false),
        ('Là ngôn ngữ lập trình', 1, true),
        ('Không là ngôn ngữ lập trình', 1, false),
        ('Là ngôn ngữ lập trình', 1, true);
        
INSERT INTO exam(`code`, title, category_id, duration, creator_id, create_date)
VALUES  ('A1', 'Bài thi A1', 1, 20, 1, '2021-10-19'),
        ('B2', 'Bài thi B2', 2, 30, 1, '2021-10-19'),
        ('C3', 'Bài thi C3', 3, 40, 1, '2021-10-19'),
        ('D4', 'Bài thi D4', 4, 50, 1, '2021-10-19'),
        ('E5', 'Bài thi E5', 5, 60, 1, '2021-10-19');
        
INSERT INTO exam_question(exam_id, question_id)
VALUES  (1, 2),
        (2, 3),
        (3, 4),
        (4, 5),
        (5, 1);