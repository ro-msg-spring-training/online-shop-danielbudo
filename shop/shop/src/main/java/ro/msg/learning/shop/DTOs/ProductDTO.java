package ro.msg.learning.shop.DTOs;

import lombok.*;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Entities.Supplier;

import java.io.Serializable;
import java.math.BigDecimal;
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class ProductDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    // Category related attributes
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
    // Supplier related attributes
    private Integer supplierId;
    private String supplierName;

    private String imageUrl;

}
