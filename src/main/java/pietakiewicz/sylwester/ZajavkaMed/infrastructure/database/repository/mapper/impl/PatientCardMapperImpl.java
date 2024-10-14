package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientCardEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientCardEntityMapper;

import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class PatientCardMapperImpl implements PatientCardEntityMapper {

    public PatientCard fromEntity(PatientCardEntity patientCardEntity) {
        return PatientCard.builder()
                .patientCardId(patientCardEntity.getId())
                .uuid(UUID.fromString(patientCardEntity.getUuid()))
                .build();
    }

    public PatientCardEntity toEntity(PatientCard patientCard) {
        return PatientCardEntity.builder()
                .id(patientCard.getPatientCardId())
                .uuid(patientCard.getUuid().toString())
                .build();
    }
}
