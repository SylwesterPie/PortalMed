package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientEntity;

@Component
public interface PatientEntityMapper {
    Patient fromEntity(PatientEntity patient);

    PatientEntity toEntity(Patient patient);
}
