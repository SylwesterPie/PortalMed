CREATE TYPE status
	AS ENUM('PLANNED', 'IN_PROGRESS', 'FINISHED', 'CANCELED');

CREATE TABLE appointments
(
	appointment_id SERIAL NOT NULL,
	appointment_uuid VARCHAR(32) NOT NULL,
	doctor_id INT NOT NULL,
	patient_id INT NOT NULL,
	description TEXT,
	date TIMESTAMP NOT NULL,
	status STATUS NOT NULL,
	CONSTRAINT fk_doctors_appointments
		FOREIGN KEY (doctor_id)
			REFERENCES doctors (doctor_id),
	CONSTRAINT fk_patients_appointments
		FOREIGN KEY (patient_id)
			REFERENCES patients (patient_id)
);