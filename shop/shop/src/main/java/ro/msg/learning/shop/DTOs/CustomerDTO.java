package ro.msg.learning.shop.DTOs;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class CustomerDTO implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailAddress;
}
