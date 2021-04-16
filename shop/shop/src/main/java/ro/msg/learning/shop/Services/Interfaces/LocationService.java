package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.LocationDTO;

import java.util.List;

@Component
public interface LocationService {
    List<LocationDTO> getAllLocations();
    LocationDTO searchById(Integer id);
    void delete(Integer id);
    void addLocation(LocationDTO locationDTO);
}