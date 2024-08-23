package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.AppointmentEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.AppointmentEntityMapper;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.DoctorEntityMapper;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientEntityMapper;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AppointmentEntityMapperImpl implements AppointmentEntityMapper {

    private PatientEntityMapper patientEntityMapper;
    private DoctorEntityMapper doctorEntityMapper;

    @Override
    public Appointment fromEntity(AppointmentEntity entity) {
        return Appointment.builder()
                .appointmentId(entity.getId())
                .uuid(
                        UUID.fromString(entity.getUuid())
                )
                .patient(
                        patientEntityMapper
                                .fromEntity(entity.getPatient())
                )
                .doctor(
                        doctorEntityMapper
                                .fromEntity(entity.getDoctor())
                )
                .date(entity.getDate())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public AppointmentEntity toEntity(Appointment appointment) {
        return AppointmentEntity.builder()
                .id(appointment.getAppointmentId())
                .uuid(
                        appointment.getUuid().toString()
                )
                .patient(
                        patientEntityMapper
                                .toEntity(appointment.getPatient())
                )
                .doctor(
                        doctorEntityMapper
                                .toEntity(appointment.getDoctor())
                )
                .date(appointment.getDate())
                .status(appointment.getStatus())
                .build();
    }
}
