CREATE TABLE patients_cards
(
	patient_card_id SERIAL NOT NULL,
	patient_card_uuid VARCHAR(32) NOT NULL UNIQUE
);