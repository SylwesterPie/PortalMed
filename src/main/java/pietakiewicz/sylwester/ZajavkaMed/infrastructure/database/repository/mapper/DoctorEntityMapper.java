package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.DoctorEntity;

@Component
public interface DoctorEntityMapper {
    Doctor fromEntity(DoctorEntity doctor);

    DoctorEntity toEntity(Doctor doctor);
}
