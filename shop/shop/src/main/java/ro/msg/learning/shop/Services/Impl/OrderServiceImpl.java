package ro.msg.learning.shop.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ro.msg.learning.shop.Converters.AddressConverter;
import ro.msg.learning.shop.Converters.CustomerConverter;
import ro.msg.learning.shop.Converters.OrderConverter;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.DTOs.OrderDetailsDTO;
import ro.msg.learning.shop.DTOs.StockDTO;
import ro.msg.learning.shop.Entities.*;
import ro.msg.learning.shop.Repositories.*;
import ro.msg.learning.shop.Services.Interfaces.OrderService;
import ro.msg.learning.shop.Services.Interfaces.ProductService;
import ro.msg.learning.shop.Strategies.Interfaces.Strategy;
import ro.msg.learning.shop.Strategies.SingleLocationStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private AddressConverter addressConverter;
    @Autowired
    private ProductService productService;
    @Autowired
    private Strategy strategy;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderConverter.convertEntityToDto(orderRepository.findAll());
    }

    @Override
    public Optional<OrderDTO> getOrder(Integer id) {
        Optional<Order> order = this.orderRepository.findById(id);
        Optional<OrderDTO> orderDTO = Optional.empty();

        if(order.isEmpty())
            return orderDTO;
        else
            return Optional.of(orderConverter.entityToDto(order.get()));
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        boolean singleLocation = false;
        List<StockDTO> stockDTOList = strategy.findStock(orderDTO);
        List<Order> orders = new ArrayList<>();
        Order order1 = null;
        Order order2 = null;
        Address address = addressConverter.dtoToEntity(orderDTO.getAddress());
        if(strategy.getClass() == SingleLocationStrategy.class){
            Optional<Location> location = locationRepository.findById(stockDTOList.get(0).getLocation().getId());
            order2 = Order.builder()
                    .shippedFrom(location.get())
                    .createdAt(orderDTO.getCreatedAt())
                    .customer(customerConverter.dtoToEntity(orderDTO.getCustomer()))
                    .address(address)
                    .build();
            order1 = orderRepository.save(order2);
            orders.add(order2);
            singleLocation = true;
        }

        for(StockDTO stockDTO: stockDTOList){
            Optional<Location> location = locationRepository.findById(stockDTO.getLocation().getId());
            if(singleLocation == false){
                order2 = Order.builder()
                        .shippedFrom(location.get())
                        .customer(customerConverter.dtoToEntity(orderDTO.getCustomer()))
                        .createdAt(orderDTO.getCreatedAt())
                        .address(address)
                        .build();
                order1 = orderRepository.save(order2);
                orders.add(order2);
            }

            OrderDetails orderDetails = OrderDetails.builder()
                    .orderId(order2)
                    .productId(productRepository.findById(stockDTO.getProduct().getId()).get())
                    .quantity(stockDTO.getQuantity())
                    .build();
            orderDetailsRepository.save(orderDetails);

            Stock stock = stockRepository.findStockByProductIdAndLocationId(stockDTO.getProduct().getId(), stockDTO.getLocation().getId());
            stock.setQuantity(stock.getQuantity() - stockDTO.getQuantity());
            stockRepository.save(stock);
        }
    }


}