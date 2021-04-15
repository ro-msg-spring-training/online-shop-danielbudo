package ro.msg.learning.shop.Converters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// Add some methods that will be available for all convertors
public abstract class AbstractConvertor<Entity, Dto> implements Converter<Entity, Dto> {

    // Convert multiple entities to DTOs
    public List<Dto> convertEntityToDto(Collection<Entity> entities){
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    // Convert multiple DTOs to entities
    public List<Entity> convertDtoToEntity(Collection<Dto> dtos){
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


}
