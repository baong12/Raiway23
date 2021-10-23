DROP DATABASE IF EXISTS fresher_training_management;
CREATE DATABASE fresher_training_management;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE fresher_training_management;

DROP TABLE IF EXISTS trainee;
CREATE TABLE trainee(
    trainee_id          INT AUTO_INCREMENT PRIMARY KEY,
    full_name           VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    birth_date          DATE NOT NULL,
    gender              ENUM('male', 'female', 'unknown'),
    et_iq               INT CHECK(0 <= et_iq AND et_iq <= 20),
    et_gmath            INT CHECK(0 <= et_gmath AND et_gmath <= 20),
    et_english          INT CHECK(0 <= et_english AND et_english <= 50),
    training_class      VARCHAR(20) CHAR SET utf8mb4 NOT NULL,
    evaluation_notes    VARCHAR(255) CHAR SET utf8mb4 NOT NULL 
);

ALTER TABLE trainee
ADD vti_account VARCHAR(50) NOT NULL UNIQUE;

-- Question 1: Add at least 10 records into created table
INSERT INTO trainee(full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes, vti_account)
VALUES  ('Nguyễn Thành Long',   '1996-12-03', 'male',   12,     8,      30, 'Railway 1',    'Excellent',    'long_nguyen96'),
        ('Ngô Hoàng Sơn',       '1997-09-12', 'male',   13,     17,     35, 'Railway 2',    'Good',         'son_ngo97'),
        ('Vũ Thái Huy',         '1998-01-02', 'male',   3,      7,      26, 'Rocket 3',     'Average',      'huy_vu98'),
        ('Trần Mạnh Duy',       '1997-04-10', 'male',   11,     16,     33, 'Rocket 4',     'Bad',          'duy_tran'),
        ('Huỳnh Quang Ngọc',    '1996-12-11', 'male',   20,     10,     49, 'Spaceship 5',  'Oh my god',    'ngoc_huynh96'),
        ('Phạm Hồng Ngọc',      '1998-06-30', 'female', 15,     9,      43, 'Spaceship 6',  'Godlike',      'ngoc_pham98'),
        ('Trịnh Thanh Thủy',    '1999-07-31', 'female', 10,     10,     14, 'Mothership 7', 'Inhuman',      'thuy_trinh99'),
        ('Phí Hương Giang',     '2000-03-26', 'female', 18,     6,      22, 'Mothership 8', 'Insane',       'giang_phi2k'),
        ('Nguyễn Anh Thư',      '1994-09-21', 'female', 16,     2,      31, 'Planet 9',     'Advanced',     'thu_nguyen94'),
        ('Hồ Phương Anh',       '1993-10-22', 'female', 17,     3,      37, 'Planet 10',    'Amazing good job', 'anh_ho93');
SELECT * FROM trainee;

-- Question 2: Query all the trainees who passed the entry test, group them into
-- different birth months
SELECT GROUP_CONCAT(full_name) AS entry_trainee, YEAR(birth_date)
FROM trainee
GROUP BY MONTH(birth_date);

-- Question 3: Query the trainee who has the longest name, showing his/her age along
-- with his/her basic information (as defined in the table)
SELECT full_name, birth_date, gender, LENGTH(full_name) as name_length
FROM trainee
WHERE LENGTH(full_name) = (
    SELECT MAX(LENGTH(full_name))
    FROM trainee
);

-- Question 4: Query all the ET-passed trainees. One trainee is considered as ET-passed
-- when he/she has the entry test points satisfy below criteria
-- ET_IQ + ET_Gmath >= 20
-- ET_IQ >= 8
-- ET_Gmath >= 8
-- ET_English >= 18
SELECT *
FROM trainee
WHERE et_iq + et_gmath >= 20
AND et_iq >= 8
AND et_gmath >= 8
AND et_english >= 18;

-- Quết sần 5: Delete information of trainee who has TraineeID = 3
DELETE
FROM trainee
WHERE trainee_id = 3;
SELECT * FROM trainee;

-- Quết sần 6: Trainee who has TraineeID = 5 move to '2' class. Let update information
-- into database
UPDATE trainee
SET training_class = '2'
WHERE trainee_id = 5;
SELECT * FROM trainee;