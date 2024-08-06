package pietakiewicz.sylwester.ZajavkaMed.business;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.AppointmentDAO;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.DoctorDAO;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;

import java.util.Optional;

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
}
