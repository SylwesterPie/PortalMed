package pietakiewicz.sylwester.ZajavkaMed.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientCardDAO;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class PatientCardService {

    private final PatientCardDAO patientCardDAO;

    public PatientCard findPatientCard(UUID uuid) {
        Optional<PatientCard> patientCard = patientCardDAO.findByUuid(uuid.toString());
        if(patientCard.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patientCard.get();
    }

    public PatientCard findPatientCard(Integer patientCardId) {
        Optional<PatientCard> patientCard = patientCardDAO.findById(patientCardId);
        if(patientCard.isEmpty()){
            throw new RuntimeException(); //TODO Create exception and change
        }
        return patientCard.get();
    }


}
