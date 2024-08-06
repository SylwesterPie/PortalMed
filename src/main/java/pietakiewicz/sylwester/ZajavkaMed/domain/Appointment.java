package pietakiewicz.sylwester.ZajavkaMed.domain;

import java.time.OffsetDateTime;
import java.util.UUID;


public class Appointment {
    Integer appointmentId;
    UUID UUID;
    Patient patient;
    Doctor doctor;
    OffsetDateTime data;
    AppointmentStatus status;
}
