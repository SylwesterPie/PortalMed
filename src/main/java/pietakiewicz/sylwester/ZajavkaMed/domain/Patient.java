package pietakiewicz.sylwester.ZajavkaMed.domain;

import java.time.OffsetDateTime;

public class Patient {
    Integer id;
    String email;
    String name;
    String surname;
    String pesel;
    OffsetDateTime birthday;
    PatientCard patientCard;
}
