package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientCardEntity;

@Component
public interface PatientCardEntityMapper {
    PatientCard fromEntity(PatientCardEntity patientCardEntity);

    PatientCardEntity toEntity(PatientCard patientCard);
}
