DROP DATABASE IF EXISTS fresher_training_management;
CREATE DATABASE fresher_training_management;
ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE fresher_training_management;

CREATE TABLE trainee(
    trainee_id          INT AUTO_INCREMENT PRIMARY KEY,
    full_name           VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    birth_date          DATE,
    gender              ENUM('male', 'female', 'unknown'),
    et_iq               INT CHECK(0 <= et_iq AND et_iq <= 20),
    et_gmath            INT CHECK(0 <= et_gmath AND et_gmath <= 20),
    et_english          INT CHECK(0 <= et_english AND et_english <= 50),
    training_class      VARCHAR(20),
    evaluation_notes    VARCHAR(255)
);

ALTER TABLE trainee
ADD vti_account VARCHAR(50) NOT NULL UNIQUE;