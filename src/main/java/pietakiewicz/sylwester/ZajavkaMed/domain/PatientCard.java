package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@With
@EqualsAndHashCode
@ToString(of = "uuid")
public class PatientCard {
    String uuid;
    List<Diseases> diseasesList;
    List<Medicament> medicamentList;
    List<Appointment> appointmentList;

}
