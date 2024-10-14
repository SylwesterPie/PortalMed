package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientEntity;

import java.util.Optional;

@Repository
public interface PatientJpaRepository extends JpaRepository<PatientEntity, Long> {

    Optional<PatientEntity> findByPesel(String pesel);
}
