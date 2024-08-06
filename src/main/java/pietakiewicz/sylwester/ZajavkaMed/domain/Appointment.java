package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@With
@Builder
@Value
@EqualsAndHashCode(of = "UUID")
@ToString(of = {"appointmentId", "patient", "doctor", "status"})
public class Appointment {
    Integer appointmentId;
    UUID UUID;
    Patient patient;
    Doctor doctor;
    OffsetDateTime data;
    AppointmentStatus status;
}
