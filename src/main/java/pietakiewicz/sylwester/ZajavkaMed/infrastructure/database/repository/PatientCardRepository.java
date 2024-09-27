package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.business.dao.PatientCardDAO;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa.PatientCardJpaRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PatientCardRepository implements PatientCardDAO {

    private final PatientCardJpaRepository patientCardJpaRepository;

    @Override
    public Optional<PatientCard> findByUuid(String uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<PatientCard> findById(Integer patientCardId) {
        return Optional.empty();
    }
}
