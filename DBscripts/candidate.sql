DROP TABLE IF EXISTS Candidate;


CREATE TABLE Candidate (
       candidate_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
       candidate_name VARCHAR (100),
	   candidate_education VARCHAR (50),
       candidate_hometown VARCHAR (25),
	   candidate_experience VARCHAR (25),
	   candidate_agenda VARCHAR (100),
       election_name VARCHAR (100),
       PRIMARY KEY (candidate_id),
	   FOREIGN KEY (election_name) REFERENCES Election(election_name)
);

INSERT INTO Candidate (candidate_name,candidate_education,candidate_hometown,candidate_experience,candidate_agenda,candidate_election_name)
       VALUES  	('Md. Ahsan Bari', 'Bsc in Philoshopy', 'Cumilla', '5 years as Mayor', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Rajshahi', '1 year as Minister', 'I will make this Dhaka city better','Dhaka City Mayor Election'),
             	('Md. Syed Fahim', 'Bsc in English', 'Dhaka', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'), 
				('Md. Kazi Yasin Ali', 'Msc in ICT', 'Rangpur', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Abul Baser', 'Bsc in EEE', 'Khulna', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),               	
             	('Md. Fazle Rabbi', 'Bsc in CSE', 'Cumilla', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election'),             	
				('Md. Fazle Hasan', 'Bsc in CSE', 'Barishal', 'None', 'I will make this Dhaka city better','Dhaka City Mayor Election')


