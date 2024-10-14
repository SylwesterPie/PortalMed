CREATE TABLE patients
(
	patient_id SERIAL NOT NULL  UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	pesel VARCHAR(11) NOT NULL UNIQUE,
	date_birthday DATE NOT NULL
);

CREATE TABLE patients_cards
(
	patient_card_id SERIAL NOT NULL,
	patient_card_uuid VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE patients_patients_cards
(
	patient_id INT NOT NULL UNIQUE,
	patient_card_id INT NOT NULL UNIQUE,
	PRIMARY KEY(doctor_id, patient_card_id),
	CONSTRAINT fk_doctors_specializations_doctors
		FOREIGN KEY (doctor_id)
			REFERENCES doctors (doctor_id),
	CONSTRAINT fk_specializations_specializations_doctors
		FOREIGN KEY (specialization_id)
			REFERENCES specializations (specialization_id)
);