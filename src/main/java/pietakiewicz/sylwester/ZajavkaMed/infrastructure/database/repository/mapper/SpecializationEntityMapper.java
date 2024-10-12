package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Specialization;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.SpecializationEntity;

@Component
public interface SpecializationEntityMapper {

    Specialization fromEntity(SpecializationEntity specializationEntity);

    SpecializationEntity toEntity(Specialization specialization);
}
