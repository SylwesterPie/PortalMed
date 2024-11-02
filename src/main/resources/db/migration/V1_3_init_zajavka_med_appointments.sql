CREATE TYPE status
	AS ENUM('PLANNED', 'IN_PROGRESS', 'FINISHED', 'CANCELED');

CREATE TABLE appointment
(
	appointment_id SERIAL NOT NULL,
	appointment_uuid VARCHAR(32) NOT NULL,
	doctor_id INT NOT NULL,
	patient_id INT NOT NULL,
	description TEXT,
	date TIMESTAMP NOT NULL,
	status STATUS NOT NULL,
	CONSTRAINT fk_doctor_appointment
		FOREIGN KEY (doctor_id)
			REFERENCES doctor (doctor_id),
	CONSTRAINT fk_patient_appointment
		FOREIGN KEY (patient_id)
			REFERENCES patient (patient_id)
);