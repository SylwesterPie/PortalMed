package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;

import java.util.Optional;

public interface DoctorDAO {

    Optional<Doctor> findByCert(String cert);

    Optional<Doctor> findById(Integer patientId);

    void saveDoctor(Doctor patient);

    void updateDoctor(Doctor updateDoctor, Integer patientId);

    void deleteDoctor(Integer patientId);


}
