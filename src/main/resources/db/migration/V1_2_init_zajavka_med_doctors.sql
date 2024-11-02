CREATE TABLE doctor
(
	doctor_id SERIAL NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL
);

CREATE TABLE specialization
(
	specialization_id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	description TEXT NOT NULL
);

CREATE TABLE doctor_specialization
(
	doctor_id INT NOT NULL,
	specialization_id INT NOT NULL,
	PRIMARY KEY(doctor_id, specialization_id),
	CONSTRAINT fk_doctor_specialization_doctor
		FOREIGN KEY (doctor_id)
			REFERENCES doctor (doctor_id),
	CONSTRAINT fk_specialization_specialization_doctor
		FOREIGN KEY (specialization_id)
			REFERENCES specialization (specialization_id)
);