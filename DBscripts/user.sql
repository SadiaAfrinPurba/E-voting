CREATE TABLE User (
       user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       user_name VARCHAR (50),
       user_phoneNo VARCHAR (11),
	   user_email VARCHAR (50),
	   user_password VARCHAR (100),
       PRIMARY KEY (user_id,user_name,user_email)
);