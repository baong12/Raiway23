-- Exercise 1
CREATE DATABASE fresher_training_management;
USE fresher_training_management;

CREATE TABLE trainee (
	TraineeID			INT NOT NULL AUTO_INCREMENT,
    Full_Name			VARCHAR(50),
    Birth_Date			DATE,
    Gender				ENUM('male', 'female', 'unknown'),
    ET_IQ				INT CHECK(0 <= ET_IQ AND ET_IQ <= 20),
    ET_Gmath			INT CHECK(0 <= ET_Gmath AND ET_Gmath <= 20),
    ET_English			INT CHECK(0 <= ET_English AND ET_English <= 50),
    Training_Class		VARCHAR(50),
    Evaluation_Notes	VARCHAR(500),
    PRIMARY KEY(TraineeID)
);

ALTER TABLE trainee ADD COLUMN VTI_Account VARCHAR(50) NOT NULL UNIQUE;