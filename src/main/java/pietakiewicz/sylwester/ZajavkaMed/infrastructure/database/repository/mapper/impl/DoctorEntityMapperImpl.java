package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Doctor;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.DoctorEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.DoctorEntityMapper;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.SpecializationEntityMapper;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEntityMapperImpl implements DoctorEntityMapper {

    private SpecializationEntityMapper specializationMapper;

    @Override
    public Doctor fromEntity(DoctorEntity doctor) {
        return Doctor.builder()
                .id(doctor.getId())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .specializations(
                        doctor.getSpecializations().stream()
                                .map(specializationMapper::fromEntity)
                                .collect(Collectors.toSet())
                )
                .build();
    }

    @Override
    public DoctorEntity toEntity(Doctor doctor) {
        return DoctorEntity.builder()
                .id(doctor.getId())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .specializations(
                        doctor.getSpecializations().stream()
                                .map(specializationMapper::toEntity)
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
