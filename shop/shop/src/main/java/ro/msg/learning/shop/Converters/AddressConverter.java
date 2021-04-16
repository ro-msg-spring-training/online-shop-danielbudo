package ro.msg.learning.shop.Converters;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.AddressDTO;
import ro.msg.learning.shop.Entities.Address;

@Component
public class AddressConverter extends AbstractConvertor<Address, AddressDTO> {
    @Override
    public Address dtoToEntity(AddressDTO addressDTO) {
        return Address.builder()
                .city(addressDTO.getCity())
                .county(addressDTO.getCounty())
                .country(addressDTO.getCountry())
                .streetAddress(addressDTO.getStreetAddress())
                .build();
    }

    @Override
    public AddressDTO entityToDto(Address address) {
        return AddressDTO.builder()
                .city(address.getCity())
                .county(address.getCounty())
                .country(address.getCountry())
                .streetAddress(address.getStreetAddress())
                .build();
    }
}
