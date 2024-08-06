package pietakiewicz.sylwester.ZajavkaMed.domain;

import java.util.List;

public class Doctor {
    Integer id;
    String email;
    String name;
    String surname;
    String cert;
    List<Specialization> specializations;
}
