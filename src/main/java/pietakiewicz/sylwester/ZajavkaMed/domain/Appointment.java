package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@With
@Builder
@Value
@EqualsAndHashCode(of = "appointmentId")
@ToString(of = {"appointmentId", "patient", "doctor", "status"})
public class Appointment {
    Long appointmentId;
    UUID uuid;
    Patient patient;
    Doctor doctor;
    LocalDateTime date;
    AppointmentStatus status;
}
