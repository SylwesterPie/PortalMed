package pietakiewicz.sylwester.ZajavkaMed.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.security.UserEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.security.UserRepository;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PatientService {

    private final PatientDAO patientDAO;
    private final UserRepository userRepository;

    public Patient findPatient(String pesel) {
        Optional<Patient> patient = patientDAO.findByPesel(pesel);
        if(patient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patient.get();
    }

    public Patient findPatient(Integer patientId) {
        Optional<Patient> patient = patientDAO.findById(patientId);
        if(patient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patient.get();
    }

    public Patient findPatientByUserName(String userName) {
        UserEntity user = userRepository.findByUserName(userName);
        Optional<Patient> patient = patientDAO.findByEmail(user.getEmail());
        if(patient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patient.get();
    }

    @Transactional
    public Patient updatePatient(Patient updatePatient, Integer patientId){
        patientDAO.updatePatient(updatePatient, patientId);
        Optional<Patient> newPatient = patientDAO.findById(patientId);
        if (newPatient.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return newPatient.get();
    }
}
