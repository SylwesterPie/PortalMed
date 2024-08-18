package pietakiewicz.sylwester.ZajavkaMed.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "specializationId")
@ToString
public class Specialization {
    Long specializationId;
    String name;
    String desc;
}
