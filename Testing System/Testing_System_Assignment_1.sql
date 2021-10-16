CREATE DATABASE testing_system_assignment_1;
USE testing_system_assignment_1;

CREATE TABLE department (
	DepartmentID			INT,
    DepartmentName			VARCHAR(50)
);

CREATE TABLE position (
	PositionID				INT,
    PositionName			VARCHAR(50)
);

CREATE TABLE account (
    AccountID 				INT,
    Email 					VARCHAR(50),
    Username 				VARCHAR(50),
    FullName 				VARCHAR(50),
    DepartmentID 			VARCHAR(50),
    PositionID 				VARCHAR(50),
    CreateDate 				DATE
);

CREATE TABLE `group` (
	GroupID					INT,
    GroupName				VARCHAR(50),
    CreatorID				INT,
    CreateDate				DATE
);

CREATE TABLE groupaccount (
	GroupID					INT,
    AccountID				INT,
    JoinDate				DATE
);

CREATE TABLE typequestion (
	TypeID					INT,
    TypeName				VARCHAR(50)
);

CREATE TABLE categoryquestion (
	CategoryID				INT,
    CategoryName			VARCHAR(50)
);

CREATE TABLE question (
	QuestionID				INT,
    Content					VARCHAR(200),
    CategoryID				INT,
    TypeID					INT,
    CreatorID				INT,
    CreateDate				DATE
);

CREATE TABLE answer (
	AnswerID				INT,
    Content					VARCHAR(2000),
    QuestionID				INT,
    isCorrect				BOOLEAN
);

CREATE TABLE exam (
	ExamID					INT,
    Code					VARCHAR(50),
    Title					VARCHAR(200),
    CategoryID				INT,
    Duration				DATETIME,
    CreatorID				INT,
    CreateDate				DATE
);

CREATE TABLE examquestion (
	ExamID					INT,
    QuestionID				INT
);

