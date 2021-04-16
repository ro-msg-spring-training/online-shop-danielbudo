package ro.msg.learning.shop.Strategies;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Converters.LocationConverter;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Converters.StockConverter;
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
public class MostAbundantStrategy implements Strategy {
    LocationRepository locationRepository;
    StockRepository stockRepository;
    ProductConverter productConverter;
    LocationConverter locationConverter;

    @Override
    public List<StockDTO> findStock(OrderDTO orderDTO) {
        List<StockDTO> stockDTOList = new ArrayList<>();
        for(OrderDetailsDTO orderDetailsDTO: orderDTO.getDetailsDTOs()){
            List<Stock> stockList = stockRepository
                    .findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(orderDetailsDTO.getProduct().getId(), orderDetailsDTO.getQuantity());

            if(stockList == null){
                throw new RuntimeException("No stock for this product");
            }
            else {
                Stock stock = stockList.get(0);
                stockDTOList.add(
                  StockDTO.builder()
                          .product(productConverter.entityToDto(stock.getProductId()))
                          .quantity(stock.getQuantity())
                          .location(locationConverter.entityToDto(stock.getLocationId()))
                          .build()
                );
            }
        }
        return stockDTOList;
    }
}