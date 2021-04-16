package ro.msg.learning.shop.Strategies;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Converters.LocationConverter;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.OrderDetailsDTO;
import ro.msg.learning.shop.DTOs.StockDTO;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Strategies.Interfaces.Strategy;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class SingleLocationStrategy implements Strategy {

    private StockRepository stockRepository;
    private LocationRepository locationRepository;

    private ProductConverter productConverter;
    private LocationConverter locationConverter;

    @Override
    public List<StockDTO> findStock(OrderDTO orderDTO) {
        boolean found;
        for(Location location: locationRepository.findAll()){
            found = true;
            List<StockDTO> stockDTOList = new ArrayList<>();
            for(OrderDetailsDTO orderDetailsDTO: orderDTO.getDetailsDTOs()){
                Stock stockList =
                        stockRepository
                                .findStockByProductIdAndQuantityGreaterThanEqualAndLocationId
                                        (productConverter.dtoToEntity(orderDetailsDTO.getProduct()), orderDetailsDTO.getQuantity(), location);
                if(stockList == null){
                    found = false;
                    break;
                }
                Stock stock = stockList;
                stockDTOList.add(
                        StockDTO.builder()
                                .product(productConverter.entityToDto(stock.getProductId()))
                                .location(locationConverter.entityToDto(stock.getLocationId()))
                                .quantity(stock.getQuantity())
                                .build()
                );
            }
            if(found)
                return stockDTOList;
        }
        throw new RuntimeException("Stock not found (by Single Location Strategy).");
    }
}
