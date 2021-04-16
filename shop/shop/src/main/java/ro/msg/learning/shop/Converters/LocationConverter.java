package ro.msg.learning.shop.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.LocationDTO;
import ro.msg.learning.shop.Entities.Location;

@Component
public class LocationConverter extends AbstractConvertor<Location, LocationDTO>{
    @Autowired
    AddressConverter addressConverter;

    @Override
    public Location dtoToEntity(LocationDTO locationDTO) {
        return Location.builder()
                .id(locationDTO.getId())
                .name(locationDTO.getName())
                .address(addressConverter.dtoToEntity(locationDTO.getAddressDTO()))
                .build();
    }

    @Override
    public LocationDTO entityToDto(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .addressDTO(addressConverter.entityToDto(location.getAddress()))
                .build();
    }
}
