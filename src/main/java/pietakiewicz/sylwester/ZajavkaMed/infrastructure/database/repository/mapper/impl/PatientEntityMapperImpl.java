package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientCardEntityMapper;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientEntityMapper;

import java.time.ZoneOffset;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntityMapperImpl implements PatientEntityMapper {

    private PatientCardEntityMapper patientCardEntityMapper;

    @Override
    public Patient fromEntity(PatientEntity patient) {
        return Patient.builder()
                .patientId(patient.getId())
                .email(patient.getEmail())
                .name(patient.getName())
                .surname(patient.getSurname())
                .pesel(patient.getPesel())
                .birthday(patient.getDateBirthday().atStartOfDay().atOffset(ZoneOffset.UTC))
                .patientCard(
                        patientCardEntityMapper
                                .fromEntity(patient.getPatientCard())
                )
                .build();
    }

    @Override
    public PatientEntity toEntity(Patient patient) {
        return PatientEntity.builder()
                .id(patient.getPatientId())
                .email(patient.getEmail())
                .name(patient.getName())
                .surname(patient.getSurname())
                .pesel(patient.getPesel())
                .dateBirthday(patient.getBirthday().toLocalDate())
                .patientCard(
                        patientCardEntityMapper
                                .toEntity(patient.getPatientCard())
                )
                .build();
    }
}
