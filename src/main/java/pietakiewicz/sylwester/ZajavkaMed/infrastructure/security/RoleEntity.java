package pietakiewicz.sylwester.ZajavkaMed.infrastructure.security;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = "role")
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "role_patient")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role")
    private String role;
}
