package remoteapi.bsmUser;
import lombok.*;

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
}
