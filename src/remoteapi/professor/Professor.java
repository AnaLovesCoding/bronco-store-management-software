package remoteapi.professor;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private String broncoId;
    private String department;
    private String office;
    private String research;
}
