package pietakiewicz.sylwester.ZajavkaMed.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        UserEntity user = userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("Don't find user"));
        return patientDAO.findByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("Don't find patient"));
    }

    @Transactional
    public void updateEmail(String username, String newEmail){
        String oldEmail = userRepository
                .findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Don't find user"))
                .getEmail();
        try {
            patientDAO.updateEmailByOldEmail(newEmail, oldEmail);
            log.info("User change email, old: {} new: {}", oldEmail, newEmail);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public boolean updatePassword(String userName, String oldPassword, String newPassword, String confirmPassword) {
        UserEntity user = userRepository
                .findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Don't find user"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!(encoder.matches(oldPassword, user.getPassword()))) return false;

        if (newPassword.contentEquals(confirmPassword)) {
            String encodePassword = encoder.encode(newPassword);
            userRepository.updatePasswordByUserName(userName, encodePassword);
            return true;
        }

        return false;
    }
}
