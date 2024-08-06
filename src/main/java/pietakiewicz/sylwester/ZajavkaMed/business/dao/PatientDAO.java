package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientDAO {

    Optional<Patient> findByPesel(String pesel);

    Optional<Patient> findById(Integer patientId);

    void savePatient(Patient patient);

    Patient updatePatient(Patient updatePatient, Integer patientId);

    void deletePatient(Integer patientId);


}
