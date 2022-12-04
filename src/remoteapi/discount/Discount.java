package remoteapi.discount;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    private Long discountId;
    private Long studentDiscount;
    private Long professorDiscount;
}
