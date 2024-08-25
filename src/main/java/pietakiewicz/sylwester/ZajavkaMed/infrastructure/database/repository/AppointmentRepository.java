package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.AppointmentDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa.AppointmentJpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AppointmentRepository implements AppointmentDAO {

    private AppointmentJpaRepository appointmentJpaRepository;

    @Override
    public Optional<Appointment> findByUUID(String appointmentUUID) {
        return Optional.empty();
    }

    @Override
    public List<Appointment> getAllAppointmentsForPatient(String patientId) {
        return List.of();
    }

    @Override
    public List<Appointment> getAllAppointmentsForDoctor(String doctorId) {
        return List.of();
    }

    @Override
    public List<Appointment> getAllComingSoonAppointmentsForPatient(String patientId) {
        return List.of();
    }
}
