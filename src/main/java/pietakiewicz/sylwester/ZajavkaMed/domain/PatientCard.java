package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@With
@EqualsAndHashCode(of = "patientCardId")
@ToString(of = "uuid")
public class PatientCard {
    Long patientCardId;
    UUID uuid;
    List<Diseases> diseasesList;
    List<Medicament> medicamentList;
    List<Appointment> appointmentList;

}
