package ro.msg.learning.shop.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.StockDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.Stock;

@Component
public class StockConverter extends AbstractConvertor<Stock, StockDTO>{
    @Autowired
    ProductConverter productConverter;
    @Autowired
    LocationConverter locationConverter;

    @Override
    public Stock dtoToEntity(StockDTO stockDTO) {
        return Stock.builder()
                .productId(productConverter.dtoToEntity(stockDTO.getProduct()))
                .locationId(locationConverter.dtoToEntity(stockDTO.getLocation()))
                .quantity(stockDTO.getQuantity())
                .build();
    }

    @Override
    public StockDTO entityToDto(Stock stock) {

        return StockDTO.builder()
                .product(productConverter.entityToDto(stock.getProductId()))
                .location(locationConverter.entityToDto(stock.getLocationId()))
                .quantity(stock.getQuantity())
                .build();
    }
}