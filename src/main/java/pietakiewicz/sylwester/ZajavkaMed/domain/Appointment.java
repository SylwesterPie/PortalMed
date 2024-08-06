package pietakiewicz.sylwester.ZajavkaMed.domain;

import java.time.OffsetDateTime;

public class Appointment {
    Integer id;
    Patient patient;
    Doctor doctor;
    OffsetDateTime data;
    AppointmentStatus status;
}
