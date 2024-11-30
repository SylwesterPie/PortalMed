package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity.PatientEntity;

import java.util.Optional;

@Repository
public interface PatientJpaRepository extends JpaRepository<PatientEntity, Long> {

    Optional<PatientEntity> findByPesel(String pesel);

    Optional<PatientEntity> findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE patient SET email = :email WHERE email = :oldEmail", nativeQuery = true)
    int updateEmailByOldEmail(@Param("email") String email, @Param("oldEmail") String oldEmail);
}
