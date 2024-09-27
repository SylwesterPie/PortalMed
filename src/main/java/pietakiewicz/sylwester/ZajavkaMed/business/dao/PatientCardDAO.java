package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;

import java.util.Optional;

public interface PatientCardDAO {

    Optional<PatientCard> findByUuid(String uuid);

    Optional<PatientCard> findById(Integer patientCardId);
}
