CREATE TABLE user_patient
(
    user_id   SERIAL       NOT NULL,
    user_name VARCHAR(64)  NOT NULL,
    email     VARCHAR(64)  NOT NULL UNIQUE,
    password  VARCHAR(256) NOT NULL,
    active    BOOLEAN      NOT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT fk_user_patient_email
        FOREIGN KEY (email)
            REFERENCES patient (email)
);

CREATE TABLE role_patient
(
    role_id SERIAL      NOT NULL,
    role    VARCHAR(64) NOT NULL,
    primary key (role_id)
);

CREATE TABLE user_role_patient
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_role_patient_user_patient
        FOREIGN KEY (user_id)
            REFERENCES user_patient (user_id),
    CONSTRAINT fk_user_role_patient_role_patient
        FOREIGN KEY (role_id)
            REFERENCES role_patient (role_id)
);