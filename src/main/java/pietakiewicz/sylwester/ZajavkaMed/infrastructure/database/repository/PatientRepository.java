package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa.PatientJpaRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PatientRepository  implements PatientDAO {

    private final PatientJpaRepository patientJpaRepository;

    @Override
    public Optional<Patient> findByPesel(String pesel) {
        return Optional.empty();
    }

    @Override
    public Optional<Patient> findById(Integer patientId) {
        return Optional.empty();
    }

    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public void updatePatient(Patient updatePatient, Integer patientId) {

    }

    @Override
    public void deletePatient(Integer patientId) {

    }
}
