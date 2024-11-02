CREATE TABLE patients
(
	patient_id SERIAL NOT NULL  UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	pesel VARCHAR(11) NOT NULL UNIQUE,
	date_birthday DATE NOT NULL
);

CREATE TABLE patient_card
(
	patient_card_id SERIAL NOT NULL,
	patient_card_uuid VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE patient_patient_card
(
	patient_id INT NOT NULL UNIQUE,
	patient_card_id INT NOT NULL UNIQUE,
	PRIMARY KEY(patient_id, patient_card_id),
	CONSTRAINT fk_patient_patient_card
		FOREIGN KEY (patient_id)
			REFERENCES patient (patient_id),
	CONSTRAINT fk_specializations_specializations_doctors
		FOREIGN KEY (patient_card_id)
			REFERENCES patient_card (patient_card_id)
);