package pietakiewicz.sylwester.ZajavkaMed.infrastructure.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    Optional<UserEntity> findByUserName(String userName);

    @Modifying
    @Query("UPDATE UserEntity u SET u.password = :password WHERE u.userName=:userName")
    void updatePasswordByUserName(@Param("userName") String userName, @Param("password") String newPassword);
}
