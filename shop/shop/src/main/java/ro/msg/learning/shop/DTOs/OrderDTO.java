package ro.msg.learning.shop.DTOs;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class OrderDTO implements Serializable {
    private Integer id;
    private LocationDTO shippedFrom;
    private CustomerDTO customer;
    private LocalDateTime createdAt;
    private AddressDTO address;
}