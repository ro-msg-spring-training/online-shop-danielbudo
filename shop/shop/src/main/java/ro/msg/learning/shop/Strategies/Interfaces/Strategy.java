package ro.msg.learning.shop.Strategies.Interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.StockDTO;

import java.util.List;

@Component
public interface Strategy {
    public List<StockDTO> findStock(OrderDTO orderDTO);
}
