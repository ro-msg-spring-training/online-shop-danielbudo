package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id")
    private Integer id;
    private String name;
    @Embedded
    private Address address;
}
