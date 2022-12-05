package remoteapi.bsmUser;

import data.BsmUserData;
import lombok.*;

import java.util.Objects;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BSMUser {

    private String broncoId;
    private String firstName;
    private String lastName;
    private String dob;
    private String phone;
    private Long addressId;
    private String userType;

    public Long getDiscount() {
        Long professorDiscount = BsmUserData.discount.getProfessorDiscount();
        Long studentDiscount = BsmUserData.discount.getStudentDiscount();

        if (Objects.equals(userType, "STUDENT")) return studentDiscount;
        if (Objects.equals(userType, "PROFESSOR")) return professorDiscount;

        if (professorDiscount > studentDiscount) return professorDiscount;
        return studentDiscount;
    }
}
