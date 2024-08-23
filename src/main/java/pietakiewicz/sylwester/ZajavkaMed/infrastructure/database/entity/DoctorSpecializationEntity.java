package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "doctors_specializations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSpecializationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_specialization_id")
    private Long id;

    @Column(name = "doctor_id")
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "specialization_id", nullable = false)
    private SpecializationEntity specialization;
}
