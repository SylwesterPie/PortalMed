package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.DoctorDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa.DoctorJpaRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DoctorRepository implements DoctorDAO {

    private final DoctorJpaRepository doctorJpaRepository;

    @Override
    public Optional<Doctor> findByCert(String cert) {
        return Optional.empty();
    }

    @Override
    public Optional<Doctor> findById(Integer patientId) {
        return Optional.empty();
    }

    @Override
    public void saveDoctor(Doctor patient) {

    }

    @Override
    public void updateDoctor(Doctor updateDoctor, Integer patientId) {

    }

    @Override
    public void deleteDoctor(Integer patientId) {

    }
}
