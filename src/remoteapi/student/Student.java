package remoteapi.student;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String broncoId;
    private String startDate;
    private String gradDate;
    private String major;
    private String minor;
}
