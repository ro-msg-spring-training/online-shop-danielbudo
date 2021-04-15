package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class SupplierDTO implements Serializable {
    private Integer id;
    private String name;
}