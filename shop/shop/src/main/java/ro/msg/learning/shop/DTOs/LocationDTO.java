package ro.msg.learning.shop.DTOs;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor
@Data @Builder
@EqualsAndHashCode @ToString
public class LocationDTO implements Serializable{
    private Integer id;
    private String name;
    private AddressDTO addressDTO;
}
