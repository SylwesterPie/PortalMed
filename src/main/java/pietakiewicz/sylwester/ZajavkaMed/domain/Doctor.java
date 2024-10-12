package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

import java.util.Set;

@Value
@Builder
@With
@EqualsAndHashCode(of = "cert")
@ToString(of = {"email", "name", "surname"})
public class Doctor {
    Long id;
    String email;
    String name;
    String surname;
    String cert;
    Set<Specialization> specializations;
}
