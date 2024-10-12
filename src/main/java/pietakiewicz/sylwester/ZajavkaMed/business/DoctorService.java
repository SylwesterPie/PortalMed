package pietakiewicz.sylwester.ZajavkaMed.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.DoctorDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DoctorService {

    private final DoctorDAO patientDAO;

    public Doctor findDoctor(String cert) {
        Optional<Doctor> patient = patientDAO.findByCert(cert);
        if(patient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patient.get();
    }

    public Doctor findDoctor(Integer patientId) {
        Optional<Doctor> patient = patientDAO.findById(patientId);
        if(patient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patient.get();
    }

    @Transactional
    public Doctor updateDoctor(Doctor updateDoctor, Integer patientId){
        patientDAO.updateDoctor(updateDoctor, patientId);
        Optional<Doctor> newDoctor = patientDAO.findById(patientId);
        if (newDoctor.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return newDoctor.get();
    }
}
