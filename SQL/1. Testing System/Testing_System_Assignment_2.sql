DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE testing_system;

DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id		TINYINT AUTO_INCREMENT PRIMARY KEY,
    department_name		VARCHAR(50) CHAR SET utf8mb4 NOT NULL
);
INSERT INTO department(department_name)
VALUES 	(N'Marketing'),
		(N'Sales'),
        (N'Quản trị'),
        (N'Tài chính'),
        (N'Nhân sự'),
        (N'Kỹ thuật');

CREATE TABLE `position`(
	position_id		TINYINT AUTO_INCREMENT PRIMARY KEY,
    position_name	ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    account_id 		SMALLINT AUTO_INCREMENT PRIMARY KEY,
    email 			VARCHAR(50) UNIQUE NOT NULL,
    user_name 		VARCHAR(50) UNIQUE NOT NULL,
    full_name 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    department_id 	TINYINT NOT NULL,
    position_id 	TINYINT NOT NULL,
    create_date 	DATE,
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id)
);
CREATE TABLE `group`(
	group_id		TINYINT AUTO_INCREMENT PRIMARY KEY,
    group_name		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    creator_id		SMALLINT NOT NULL,
    create_date		DATE
    -- FOREIGN KEY(?)
);
CREATE TABLE group_account(
	group_id	INT AUTO_INCREMENT PRIMARY KEY,
    account_id	SMALLINT NOT NULL,
    join_date	DATE,
    FOREIGN KEY(account_id) REFERENCES `account`(account_id)
);
CREATE TABLE type_question(
	type_id		INT AUTO_INCREMENT PRIMARY KEY,
    type_name	VARCHAR(50) NOT NULL
);
CREATE TABLE category_question(
	category_id		INT AUTO_INCREMENT PRIMARY KEY,
    category_name	VARCHAR(50)
);
CREATE TABLE question(
	question_id		INT AUTO_INCREMENT PRIMARY KEY,
    content			VARCHAR(200),
    category_id		INT,
    type_id			INT,
    creator_id		INT,
    create_date		DATE
);
CREATE TABLE answer(
	answer_id		INT AUTO_INCREMENT PRIMARY KEY,
    content			VARCHAR(1000),
    question_id		INT,
    is_correct		BOOLEAN
);
CREATE TABLE exam(
	exam_id			INT AUTO_INCREMENT PRIMARY KEY,
    `code`			VARCHAR(50),
    title			VARCHAR(200),
    category_id		INT,
    duration		INT,
    creator_id		INT,
    create_date		DATE
);
CREATE TABLE exam_question(
	exam_id			INT AUTO_INCREMENT PRIMARY KEY,
    question_id		INT
);

