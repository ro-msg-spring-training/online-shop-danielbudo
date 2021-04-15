package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class OrderDetailsDTO implements Serializable {
    private OrderDTO order;
    private ProductDTO product;
    private Integer quantity;
}
