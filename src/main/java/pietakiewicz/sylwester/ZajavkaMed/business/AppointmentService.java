package pietakiewicz.sylwester.ZajavkaMed.business;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.AppointmentDAO;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.DoctorDAO;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.domain.AppointmentStatus;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentDAO appointmentDAO;
    private final DoctorDAO doctorDAO;
    private final PatientDAO patientDAO;

    Appointment findAppointment(String appointmentUUID){
        Optional<Appointment> appointment = appointmentDAO.findByUUID(appointmentUUID);
        if (appointment.isEmpty()) {
            throw new RuntimeException();
        }
        return appointment.get();
    }

    @Transactional
    Appointment createAppointment(String doctorCert, String patientPesel, LocalDateTime dateTime){
        Patient patient = patientDAO.findByPesel(patientPesel)
                .orElseThrow(() -> new RuntimeException(
                        "Patient with pesel "+ patientPesel +" is unknown"
                ));

        Doctor doctor = doctorDAO.findByCert(doctorCert)
                .orElseThrow(() -> new RuntimeException(
                        "Doctor with cert: " + doctorCert + "is unknown"
                ));

        Appointment appointment = Appointment.builder()
                .uuid(UUID.randomUUID())
                .patient(patient)
                .doctor(doctor)
                .date(dateTime)
                .status(AppointmentStatus.PLANNED)
                .build();

        appointmentDAO.saveAppointment(appointment);

        return appointment;
    }
}
