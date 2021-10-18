CREATE DATABASE fresher_training_management;
USE fresher_training_management;

CREATE TABLE trainee (
	trainee_id			INT,
    full_name			VARCHAR(50),
    birth_date			DATE,
    gender				VARCHAR(10),
    et_iq				INT,
    et_gmath			INT,
    et_english			INT,
    training_class		VARCHAR(50),
    evaluation_notes	VARCHAR(255)
);
