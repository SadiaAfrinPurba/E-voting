DROP TABLE IF EXISTS Candidate;


CREATE TABLE Candidate (
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

INSERT INTO Candidate (candidate_name,candidate_education,candidate_picture,candidate_hometown,candidate_experience,candidate_agenda,candidate_election_name)
       VALUES  	('Md. Ahsan Bari', '"Bsc in Philoshopy"', '/home/afrin/pic/candidate-1.jpg', 'Cumilla', '5 years as Mayor', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Fazle Rabbi', '"Bsc in CSE"', '/home/afrin/pic/candidate-2.jpg', 'Rajshahi', '1 year as Minister', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Syed Fahim', '"Bsc in English"', '/home/afrin/pic/candidate-3.jpg', 'Dhaka', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', '"Bsc in CSE"', '/home/afrin/pic/candidate-2.jpg', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'), 
				('Md. Kazi Yasin Ali', '"Msc in ICT"', '/home/afrin/pic/candidate-4.jpg', 'Rangpur', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', '"Bsc in CSE"', '/home/afrin/pic/candidate-2.jpg', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Abul Baser', '"Bsc in EEE"', '/home/afrin/pic/candidate-5.jpg', 'Khulna', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', '"Bsc in CSE"', '/home/afrin/pic/candidate-2.jpg', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Fazle Hasan', '"Bsc in CSE"', '/home/afrin/pic/candidate-2.jpg', 'Barishal', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election')


