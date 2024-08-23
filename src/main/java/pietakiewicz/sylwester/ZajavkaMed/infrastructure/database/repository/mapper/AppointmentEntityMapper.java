package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.AppointmentEntity;

@Component
public interface AppointmentEntityMapper {

    Appointment fromEntity(AppointmentEntity appointmentEntity);

    AppointmentEntity toEntity(Appointment appointment);
}
