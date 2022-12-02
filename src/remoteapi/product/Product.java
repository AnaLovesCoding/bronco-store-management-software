package remoteapi.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private Long currentPrice;
}
