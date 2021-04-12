package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Supplier {
    @Id @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
