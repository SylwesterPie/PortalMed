package pietakiewicz.sylwester.ZajavkaMed.infrastructure.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByUserName(String userName);

    @Modifying
    @Query("UPDATE UserEntity u SET u.email = :email WHERE u.email=:oldEmail")
    void updateEmailByOldEmail(@Param("email") String email, @Param("oldEmail") String oldEmail);
}
