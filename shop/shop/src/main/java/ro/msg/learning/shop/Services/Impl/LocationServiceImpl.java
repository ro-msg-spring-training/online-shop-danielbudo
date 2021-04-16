package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.LocationConverter;
import ro.msg.learning.shop.DTOs.LocationDTO;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Services.Interfaces.LocationService;

import java.util.List;
@Service
class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    LocationConverter locationConverter;

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationConverter.convertEntityToDto(locationRepository.findAll());
    }

    @Override
    public LocationDTO searchById(Integer id) {
        Location location = locationRepository.findById(id).orElse(null);
        if(location == null){
            throw new RuntimeException("No location with id " + id);
        }
        return locationConverter.entityToDto(location);
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void addLocation(LocationDTO locationDTO) {
        Location location = locationConverter.dtoToEntity(locationDTO);
        locationRepository.save(location);
    }
}
