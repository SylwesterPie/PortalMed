CREATE TABLE doctors
(
	doctor_id SERIAL NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL
);

CREATE TABLE specializations
(
	specialization_id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	description TEXT NOT NULL
);

CREATE TABLE doctors_specializations
(
	doctor_id INT NOT NULL,
	specialization_id INT NOT NULL,
	PRIMARY KEY(doctor_id, specialization_id),
	CONSTRAINT fk_doctors_specializations_doctors
		FOREIGN KEY (doctor_id)
			REFERENCES doctors (doctor_id),
	CONSTRAINT fk_specializations_specializations_doctors
		FOREIGN KEY (specialization_id)
			REFERENCES specializations (specialization_id)
);