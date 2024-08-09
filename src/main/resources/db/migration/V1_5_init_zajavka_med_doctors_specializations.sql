CREATE TABLE doctors_specializations
(
	doctor_specialization_id SERIAL NOT NULL,
	doctor_id INT NOT NULL,
	specialization_id INT NOT NULL,
	CONSTRAINT fk_doctors_specializations_doctors
		FOREIGN KEY (doctor_id)
			REFERENCES doctors (doctor_id),
	CONSTRAINT fk_specializations_specializations_doctors
		FOREIGN KEY (specialization_id)
			REFERENCES specializations (specialization_id)
);