CREATE TABLE specializations
(
	specialization_id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	description TEXT NOT NULL
);