package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class StockDTO implements Serializable{
    private ProductDTO product;
    private LocationDTO location;
    private Integer quantity;
}
