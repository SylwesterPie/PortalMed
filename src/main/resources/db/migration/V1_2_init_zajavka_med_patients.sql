CREATE TABLE patients
(
	patient_id SERIAL NOT NULL  UNIQUE,
	patient_card_uuid VARCHAR(32) NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	pesel VARCHAR(11) NOT NULL UNIQUE,
	date_birthday DATE NOT NULL,
	CONSTRAINT fk_patients_patients_cards
		FOREIGN KEY (patient_card_uuid)
			REFERENCES patients_cards (patient_card_uuid)
);