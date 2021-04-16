package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Entities.Order;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<OrderDTO> getAllOrders();
    Optional<OrderDTO> getOrder(Integer id);
    void delete(Integer id);
    void addOrder(OrderDTO orderDTO);
}
