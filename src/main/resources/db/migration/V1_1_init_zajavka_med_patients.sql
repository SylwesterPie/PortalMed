CREATE TABLE patient_card
(
	patient_card_uuid VARCHAR(32) NOT NULL UNIQUE,
	primary key(patient_card_uuid)
);

CREATE TABLE patient
(
	patient_id SERIAL NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	pesel VARCHAR(11) NOT NULL UNIQUE,
	date_birthday DATE NOT NULL,
	patient_card_uuid VARCHAR(32) NOT NULL,
	CONSTRAINT fk_patient_patient_card
    		FOREIGN KEY (patient_card_uuid)
    			REFERENCES patient_card (patient_card_uuid)
);