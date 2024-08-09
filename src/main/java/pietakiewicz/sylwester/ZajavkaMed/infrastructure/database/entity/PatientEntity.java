package pietakiewicz.sylwester.ZajavkaMed.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    @Column(name = "patient_card_uuid", nullable = false, unique = true, length = 32)
    private String patientCardUuid;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false, unique = true, length = 11)
    private String pesel;

    @Column(name = "date_birthday", nullable = false)
    private LocalDate dateBirthday;

    @ManyToOne
    @JoinColumn(name = "patient_card_uuid", referencedColumnName = "patient_card_uuid", insertable = false, updatable = false)
    private PatientCardEntity patientCard;
}
