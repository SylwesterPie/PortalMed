package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.DoctorEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.DoctorEntityMapper;

import java.util.List;

@Component
public class DoctorEntityMapperImpl implements DoctorEntityMapper {
    @Override
    public Doctor fromEntity(DoctorEntity doctor) {
        return Doctor.builder()
                .id(doctor.getId())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .specializations(List.of())
                .build();
    }

    @Override
    public DoctorEntity toEntity(Doctor doctor) {
        return DoctorEntity.builder()
                .id(doctor.getId())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .build();
    }


}
