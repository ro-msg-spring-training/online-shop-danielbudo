package ro.msg.learning.shop.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Converters.OrderConverter;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Order;
import ro.msg.learning.shop.Repositories.OrderRepository;
import ro.msg.learning.shop.Services.Interfaces.OrderService;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderConverter orderConverter;
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders(){
        return orderConverter.convertEntityToDto(orderRepository.findAll());
    }

    @GetMapping("/orders/{id}")
    OrderDTO getOrder(Integer id){
        Order order = orderRepository.findById(id).orElse(null);
        if(order == null)
            throw new RuntimeException("No order with id " + id);
        return orderConverter.entityToDto(order);
    }

    @PostMapping("/orders")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDTO orderDTO){
        this.orderService.addOrder(orderDTO);
        return new ResponseEntity<>("Order successfully added", HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/id")
    public void deleteOrder(@PathVariable Integer id){
        this.orderService.delete(id);
    }
}
