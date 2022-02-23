/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO department(department_name) 
VALUES
						('Marketing'	),
						('Sale'		),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'	),
						('Tài chính'	),
						('Phó giám đốc'),
						('Giám đốc'	),
						('Thư kí'		),
						('Bán hàng'	);
    
-- Add data position
INSERT INTO position	(`position_name`	) 
VALUES 					('Dev'			),
						('Test'			),
						('ScrumMaster'	);
                        
-- Add data salary                 
INSERT INTO salary		(salary_name	) 
VALUES 					('600'		),
						('700'		),
						('1500'		);


-- Add data Account
INSERT INTO `Account`(Email								, Username			, First_name,	Last_name,			create_date)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchie'		,'Chie',		'Nguyen Va'	,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chie'  ,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Hua'	,		'Bui Xua'		,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Va'		,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,	'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  Group_name			, create_date)
VALUES 				('Testing System'		,'2019-03-05'),
					('Developement'		,'2020-03-07'),
                    ('VTI Sale 01'			,'2020-03-09'),
                    ('VTI Sale 02'			,'2020-03-10'),
                    ('VTI Sale 03'			,'2020-03-28'),
                    ('VTI Creator'			,'2020-04-06'),
                    ('VTI Marketing 01'	,'2020-04-07'),
                    ('Management'			,'2020-04-08'),
                    ('Chat with love'		,'2020-04-09'),
                    ('Vi Ti Ai'			,'2020-04-10');

-- Add data Type_Question
INSERT INTO Type_Question	(Type_name	) 
VALUES 						('0'), 
							('1'); 


-- Add data Category_Question
INSERT INTO Category_Question		(Category_name	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postma'		),
									('Ruby'			),
									('Pytho'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Add data Question
INSERT INTO Question	(Content			, create_date )
VALUES 					('Câu hỏi về Java'	,'2020-04-05'),
						('Câu Hỏi về PHP'	,'2020-04-05'),
						('Hỏi về C#'		,'2020-04-06'),
						('Hỏi về Ruby'		,'2020-04-06'),
						('Hỏi về Postma'	,'2020-04-06'),
						('Hỏi về ADO.NET'	,'2020-04-06'),
						('Hỏi về ASP.NET'	,'2020-04-06'),
						('Hỏi về C++'		,'2020-04-07'),
						('Hỏi về SQL'		,'2020-04-07'),
						('Hỏi về Pytho'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, is_Correct	)
VALUES 				('Trả lời 01'	,	0		),
					('Trả lời 02'	,	1		),
                    ('Trả lời 03'	,	0		),
                    ('Trả lời 04'	,	1		),
                    ('Trả lời 05'	,	1		),
                    ('Trả lời 06'	,	1		),
                    ('Trả lời 07'	,	0		),
                    ('Trả lời 08'	,	0		),
                    ('Trả lời 09'	,	1		),
                    ('Trả lời 10'	,	1		);
	
-- Add data Exam
INSERT INTO Exam	(`Code1`			, Title				, Duration	,  create_date )
VALUES 				('S-1'			, 'Đề thi C#'			,	60		, '2019-04-05'),
					('S-2'			, 'Đề thi PHP'			,	60		, '2019-04-05'),
                    ('M-1'			, 'Đề thi C++'			,	120		, '2019-04-07'),
                    ('S-3'			, 'Đề thi Java'		,	60		, '2020-04-08'),
                    ('M-2'			, 'Đề thi Ruby'		,	120		, '2020-04-10'),
                    ('S-4'			, 'Đề thi Postma'		,	60		, '2020-04-05'),
                    ('S-5'			, 'Đề thi SQL'			,	60		, '2020-04-05'),
                    ('S-6'			, 'Đề thi Pytho'		,	60		, '2020-04-07'),
                    ('L-1'			, 'Đề thi ADO.NET'		,	180		, '2020-04-07'),
                    ('L-2'			, 'Đề thi ASP.NET'		,	180		, '2020-04-08');
