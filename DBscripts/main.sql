

CREATE TABLE User (
       user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       user_name VARCHAR (50),
       user_phoneNo VARCHAR (11),
	user_email VARCHAR (50),
	user_password VARCHAR (100),
       PRIMARY KEY (user_id)
);

CREATE TABLE Election (
       election_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       election_name VARCHAR (100) UNIQUE,
       election_start datetime,
       election_end datetime,
       PRIMARY KEY (election_id,election_name)
);

CREATE TABLE Candidate (
       candidate_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       candidate_name VARCHAR (100),
	candidate_education VARCHAR (50),
       candidate_hometown VARCHAR (25),
	candidate_experience VARCHAR (25),
	candidate_agenda VARCHAR (100),
       election_name VARCHAR (100),
       PRIMARY KEY (candidate_id),
	CONSTRAINT FK_electionName FOREIGN KEY (election_name) REFERENCES Election(election_name)
       ON DELETE CASCADE
);


CREATE TABLE Result (
       result_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       election_name VARCHAR (100),
       candidate_name VARCHAR (100),
       candidate_id INT UNSIGNED,
       result_vote INT UNSIGNED,
       PRIMARY KEY (result_id),
       CONSTRAINT FK_resultElectionName FOREIGN KEY (election_name) REFERENCES Election(election_name)
       ON DELETE CASCADE,
       CONSTRAINT FK_candidateId FOREIGN KEY (candidate_id) REFERENCES Candidate(candidate_id)
       ON DELETE CASCADE
);


INSERT INTO Election (election_name,election_start,election_end)
       VALUES ('Dhaka City Mayor Election',NOW(),NOW()),
       ('Rangpur City Mayor Election',NOW(),NOW());

INSERT INTO Candidate (candidate_name,candidate_education,candidate_hometown,candidate_experience,candidate_agenda,election_name)
       VALUES ('Md. Ahsan Bari', 'Bsc in Philoshopy', 'Cumilla', '5 years as Mayor', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Rajshahi', '1 year as Minister', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Syed Fahim', 'Bsc in English', 'Dhaka', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'), 
				('Md. Kazi Yasin Ali', 'Msc in ICT', 'Rangpur', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Abul Baser', 'Bsc in EEE', 'Khulna', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Fazle Hasan', 'Bsc in CSE', 'Barishal', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election');

