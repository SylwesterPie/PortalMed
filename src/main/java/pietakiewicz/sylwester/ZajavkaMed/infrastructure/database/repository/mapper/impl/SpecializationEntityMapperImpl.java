package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.impl;

import pietakiewicz.sylwester.ZajavkaMed.domain.Specialization;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.SpecializationEntity;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.mapper.SpecializationEntityMapper;

public class SpecializationEntityMapperImpl implements SpecializationEntityMapper {

    public static Specialization fromEntity(SpecializationEntity specializationEntity) {
        return Specialization.builder()
                .specializationId(specializationEntity.getId())
                .name(specializationEntity.getName())
                .desc(specializationEntity.getDescription())
                .build();
    }

    public static SpecializationEntity toEntity(Specialization specialization) {
        return SpecializationEntity.builder()
                .id(specialization.getSpecializationId())
                .name(specialization.getName())
                .description(specialization.getDesc())
                .build();
    }
}
