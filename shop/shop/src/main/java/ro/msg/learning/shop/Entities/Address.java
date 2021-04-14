package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@Embeddable
@EqualsAndHashCode @ToString
public class Address {
    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "street_address")
    private String streetAddress;
}
