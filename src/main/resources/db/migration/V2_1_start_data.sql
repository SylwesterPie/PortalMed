-- Dodawanie danych

-- Dodajemy karty pacjentów
INSERT INTO patient_card (patient_card_uuid) VALUES
    ('abcd1234abcd1234abcd1234abcd1234'),
    ('efgh5678efgh5678efgh5678efgh5678'),
    ('ijkl9012ijkl9012ijkl9012ijkl9012');

-- Dodajemy pacjentów
INSERT INTO patient (email, name, surname, pesel, date_birthday, patient_card_uuid) VALUES
    ('anna.kowalska@sylMed.pl', 'Anna', 'Kowalska', '12345678901', '1990-05-14', 'abcd1234abcd1234abcd1234abcd1234'),
    ('jan.nowak@sylMed.pl', 'Jan', 'Nowak', '23456789012', '1985-08-23', 'efgh5678efgh5678efgh5678efgh5678'),
    ('adam.wisniewski@sylMed.pl', 'Adam', 'Wiśniewski', '34567890123', '1975-02-12', 'ijkl9012ijkl9012ijkl9012ijkl9012');

-- Dodajemy lekarzy
INSERT INTO doctor (email, name, surname) VALUES
    ('andrzej.lekarz@sylMed.pl', 'Andrzej', 'Lekarz'),
    ('julia.medyczka@sylMed.pl', 'Julia', 'Medyczka');

-- Dodajemy specjalizacje
INSERT INTO specialization (name, description) VALUES
    ('Kardiologia', 'Specjalizacja zajmująca się chorobami serca i układu krążenia'),
    ('Dermatologia', 'Specjalizacja zajmująca się chorobami skóry');

-- Łączymy lekarzy ze specjalizacjami
INSERT INTO doctor_specialization (doctor_id, specialization_id) VALUES
    (1, 1),
    (2, 2);

-- Dodajemy spotkania (wizyty)
INSERT INTO appointment (appointment_uuid, doctor_id, patient_id, description, date, status) VALUES
    ('appnt1234abcd', 1, 1, 'Konsultacja kardiologiczna', '2024-11-10 10:00:00', 'PLANNED'),
    ('appnt5678efgh', 2, 2, 'Kontrola dermatologiczna', '2024-12-05 15:30:00', 'PLANNED');

-- Dodajemy użytkowników (user_patient) wraz z zahashowanymi hasłami bcrypt (hash wygenerowany dla wartości: anna, jan, adam)
-- Hashy bcrypt poniżej używaj jako przykładów (należy wygenerować hash z odpowiednim narzędziem).
INSERT INTO user_patient (user_name, email, password, active) VALUES
    ('anna.kowalska', 'anna.kowalska@sylMed.pl', '$2a$12$XG4qqrJi9loinrCsLit53uIWiu8hpEibZ/2UsqfAx49BfOMkyNcb6', TRUE),
    ('jan.nowak', 'jan.nowak@sylMed.pl', '$2a$12$LbWNG3ikBmQjNnhFy1wqQu1lNi4yiv9lfD6a2KXvSepDnjMd6UFy.', TRUE),
    ('adam.wisniewski', 'adam.wisniewski@sylMed.pl', '$2a$12$GwHan0LMSO.BT0MTF/opDedNI6psqhtonE3tWglvcPzW0csK.4iv6', TRUE);

-- Dodajemy role
INSERT INTO role_patient (role) VALUES
    ('PATIENT1'),
    ('PATIENT2');

-- Łączymy użytkowników z rolami (użytkownik o user_id=3 ma obie role)
INSERT INTO user_role_patient (user_id, role_id) VALUES
    (1, 1),  -- Anna Kowalska jako PACJENT1
    (2, 2),  -- Jan Nowak jako PACJENT2
    (3, 1),  -- Adam Wiśniewski jako PACJENT1
    (3, 2);  -- Adam Wiśniewski jako PACJENT2
