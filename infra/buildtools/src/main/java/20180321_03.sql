DROP TABLE address CASCADE;
DROP TABLE contact_information CASCADE;
DROP TABLE person CASCADE;
DROP TABLE role CASCADE;
DROP TABLE person_role CASCADE;


CREATE TABLE address (
	id INT PRIMARY KEY NOT NULL,
	street_no INT NOT NULL,
	barangay CHAR(20) NOT NULL,
	municipality CHAR(20) NOT NULL,
	zip_code INT NOT NULL
);

CREATE TABLE contact_information (
	id INT PRIMARY KEY NOT NULL,
	landline CHAR(20) NOT NULL,
	mobile_number CHAR(20) NOT NULL,
	email CHAR(30) NOT NULL
);

CREATE TABLE person (
	id INT PRIMARY KEY NOT NULL,
	first_name CHAR(20) NOT NULL,
	middle_name CHAR(20) NOT NULL,
	last_name CHAR(20) NOT NULL,
	address INT NOT NULL,
	birthday DATE NOT NULL,
	gwa FLOAT NOT NULL,
	date_hired DATE NOT NULL,
	currently_employed BOOLEAN NOT NULL
);


CREATE TABLE role (
	id INT PRIMARY KEY NOT NULL,
	name CHAR(10) NOT NULL
);

CREATE TABLE person_role (
	person_id INT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (person_id, role_id)
);

ALTER TABLE contact_information 
       add CONSTRAINT FKauxbhl67hx6ftcqayqtu8xmes 
       FOREIGN KEY (id) 
       REFERENCES person;
    
ALTER TABLE person 
       add CONSTRAINT FKbs1pxpi8sc2h5t4bc5uov92p 
       FOREIGN KEY (address) 
       REFERENCES address;

ALTER TABLE person_role 
       add CONSTRAINT FKs7asxi8amiwjjq1sonlc4rihn 
       FOREIGN KEY (role_id) 
       REFERENCES role
       ON DELETE CASCADE;


ALTER TABLE person_role 
       add CONSTRAINT FKhyx1efsls0f00lxs6xd4w2b3j 
       FOREIGN KEY (person_id) 
       REFERENCES person;
