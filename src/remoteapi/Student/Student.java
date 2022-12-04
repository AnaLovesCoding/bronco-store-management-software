package remoteapi.Student;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private Long broncoId;
    private Date startDate;
    private Date gradDate;
    private String major;
    private String minor;
}
