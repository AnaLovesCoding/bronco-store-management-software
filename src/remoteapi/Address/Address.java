package remoteapi.Address;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addressId;
    private String street;
    private int number;
    private String city;
    private String state;
    private int zip;

}
