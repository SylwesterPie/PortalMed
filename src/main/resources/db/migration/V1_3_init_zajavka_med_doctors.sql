CREATE TABLE doctors
(
	doctor_id SERIAL NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL
);