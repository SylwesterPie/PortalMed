package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "patient_card")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientCardEntity {

    @Id
    @Column(name = "patient_card_uuid", nullable = false, unique = true, length = 32)
    private String uuid;

}
