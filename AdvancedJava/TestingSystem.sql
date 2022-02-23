-- create database
DROP DATABASE IF EXISTS testing_system_crud;
CREATE DATABASE testing_system_crud CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE testing_system_crud;

-- create table 1: department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name 			VARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 2: Posittion
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
	position_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    position_name			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY -- mapping trên Java là String
);

-- create table 2: Posittion
DROP TABLE IF EXISTS salary;
CREATE TABLE `salary` (
	salary_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    salary_name			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- create table 3: account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    first_name				VARCHAR(50) NOT NULL,
    last_name				VARCHAR(50) NOT NULL,	-- create field fullName in POJO
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 4: group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name				VARCHAR(50) NOT NULL UNIQUE KEY,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 6: type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Essay, 1: Multiple-Choice
);

-- create table 7: category_question
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
    category_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    category_name			VARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 8: question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
    question_id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					VARCHAR(100) NOT NULL,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 9: answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
    answers					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content					VARCHAR(100) NOT NULL,
    is_correct				BIT DEFAULT 1
);

-- create table 10: exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
    exam_id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code1`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    `code2`					CHAR(10), -- NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    title					VARCHAR(50) NOT NULL,
    duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
    create_date				DATETIME DEFAULT NOW() -- Cannot update this field
);