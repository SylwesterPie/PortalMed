package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentDAO {


    Optional<Appointment> findByUUID(String appointmentUUID);

    List<Appointment> getAllAppointmentsForPatient(String patientId);

    List<Appointment> getAllAppointmentsForDoctor(String doctorId);

    List<Appointment> getAllComingSoonAppointmentsForPatient(String patientId);

    void saveAppointment(Appointment appointment);
}
