DROP TABLE IF EXISTS Voter;

CREATE TABLE Voter (
       voter_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	   voter_nid INT UNSIGNED NOT NULL,
       voter_name VARCHAR (50),
	   voter_sQuestion VARCHAR (100),
       voter_sAnswer VARCHAR (50),
       PRIMARY KEY (voter_id,voter_nid,voter_name)
);

INSERT INTO Voter (voter_nid,voter_name,voter_sQuestion,voter_sAnswer)
       VALUES  	('123456', 'Rubana Hossain', 'What is your favourite food?', 'Pizza'),
	            ('678910', 'Sadia Tasnim', 'What is your favourite place?', 'Rangamati'),
				('543210', 'Imtiyaz Hossain', 'What is your favourite book?', 'None'),
				('819876', 'Asif Chowdhury', 'What is your favourite anime?', 'Death note'),
				('612354', 'Shaminaj Disha', 'What is your favourite subject?', 'Math'),
				('732145', 'Sami Ansari', 'What is your favourite movie?', 'Intersteller'),
				('963216', 'Azwad Rab', 'What is your favourite emotion?', 'Sad'),
				('753159', 'Sharna Tasnim', 'What is your best friend name?', 'Purba'),
				('852139', 'Nadira Haider', 'What is your favourite hobby?', 'Singing'),
				('159357', 'Rifat Afrin', 'What is your favourite activity?', 'Sleep')
             	