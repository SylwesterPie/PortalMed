package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientCardEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientCardEntityMapper;

@Component
public class PatientCardMapperImpl implements PatientCardEntityMapper {

    public PatientCard fromEntity(PatientCardEntity patientCardEntity) {
        return PatientCard.builder()
                .uuid(patientCardEntity.getUuid())
                .build();
    }

    public PatientCardEntity toEntity(PatientCard patientCard) {
        return PatientCardEntity.builder()
                .uuid(patientCard.getUuid())
                .build();
    }
}
