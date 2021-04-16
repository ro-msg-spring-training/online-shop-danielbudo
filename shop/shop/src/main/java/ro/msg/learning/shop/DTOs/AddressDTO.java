package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;

@Data @Builder
@AllArgsConstructor  @NoArgsConstructor
@EqualsAndHashCode @ToString
public class AddressDTO implements Serializable{
    private String country;
    private String city;
    private String county;
    private String streetAddress;
}