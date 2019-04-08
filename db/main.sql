CREATE TABLE User (
       candidate_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
       candidate_name VARCHAR (50),
	   candidate_education VARCHAR (50),
	   candidate_picture MEDIUMBLOB NOT NULL,
       candidate_hometown VARCHAR (25),
	   candidate_experience VARCHAR (25),
	   candidate_agenda VARCHAR (100),
       candidate_election_name VARCHAR (50),
       PRIMARY KEY (candidate_id)
);