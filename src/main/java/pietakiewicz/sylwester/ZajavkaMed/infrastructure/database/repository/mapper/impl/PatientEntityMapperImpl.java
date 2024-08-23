package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import org.springframework.stereotype.Component;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;
import pietakiewicz.sylwester.ZajavkaMed.domain.PatientCard;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.PatientEntityMapper;

import java.time.ZoneOffset;

@Component
public class PatientEntityMapperImpl implements PatientEntityMapper {
    @Override
    public Patient fromEntity(PatientEntity patient) {
        return Patient.builder()
                .patientId(patient.getId())
                .email(patient.getEmail())
                .name(patient.getName())
                .surname(patient.getSurname())
                .pesel(patient.getPesel())
                .birthday(patient.getDateBirthday().atStartOfDay().atOffset(ZoneOffset.UTC))
                .patientCard(PatientCard.builder().build())
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
                .patientCardUuid(patient.getPatientCard().getUuid().toString())
                .build();
    }
}
