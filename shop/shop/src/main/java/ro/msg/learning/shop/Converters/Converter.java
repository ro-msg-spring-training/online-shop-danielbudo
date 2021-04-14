package ro.msg.learning.shop.Converters;

public interface Converter <Entity,Dto>{
    Entity dtoToEntity(Dto dto);
    Dto entityToDto(Entity entity);
}
