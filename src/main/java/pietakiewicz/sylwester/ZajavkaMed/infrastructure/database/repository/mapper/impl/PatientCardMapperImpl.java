package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientCardEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientCardEntityMapper;

import java.util.UUID;

@Component
public class PatientCardMapperImpl implements PatientCardEntityMapper {

    public static PatientCard fromEntity(PatientCardEntity patientCardEntity) {
        return PatientCard.builder()
                .patientCardId(patientCardEntity.getId())
                .uuid(UUID.fromString(patientCardEntity.getUuid()))
                .build();
    }

    public static PatientCardEntity toEntity(PatientCard patientCard) {
        return PatientCardEntity.builder()
                .id(patientCard.getPatientCardId())
                .uuid(patientCard.getUuid().toString())
                .build();
    }
}
