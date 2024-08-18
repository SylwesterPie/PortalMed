package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.SpecializationEntity;

@Repository
public interface SpecializationJpaRepository extends JpaRepository<SpecializationEntity, Long> {
}
