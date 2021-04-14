package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class ProductCategoryDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
}
