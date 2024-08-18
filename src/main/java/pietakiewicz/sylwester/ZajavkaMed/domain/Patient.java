package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.time.OffsetDateTime;

@With
@Value
@Builder
@EqualsAndHashCode(of = {"patientId"})
@ToString(of = {"patientId", "name", "surname", "email"})
public class Patient {
    Long patientId;
    String email;
    String name;
    String surname;
    String pesel;
    OffsetDateTime birthday;
    PatientCard patientCard;
}
