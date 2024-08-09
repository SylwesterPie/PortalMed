package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "patients_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_card_id")
    private Long id;

    @Column(name = "patient_card_uuid", nullable = false, unique = true, length = 32)
    private String uuid = UUID.randomUUID().toString().replace("-", "");
}
