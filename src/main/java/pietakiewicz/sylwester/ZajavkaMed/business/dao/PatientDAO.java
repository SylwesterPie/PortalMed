package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.util.Optional;

public interface PatientDAO {

    Optional<Patient> findByPesel(String pesel);

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findById(Integer patientId);

    void savePatient(Patient patient);

    void updatePatient(Patient updatePatient, Integer patientId);

    void deletePatient(Integer patientId);


}
