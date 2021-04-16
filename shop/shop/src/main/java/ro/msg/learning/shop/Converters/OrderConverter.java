package ro.msg.learning.shop.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Entities.Order;

@Component
public class OrderConverter extends AbstractConvertor<Order, OrderDTO>{
    @Autowired
    AddressConverter addressConverter;
    @Autowired
    CustomerConverter customerConverter;
    @Autowired
    LocationConverter locationConverter;

    @Override
    public Order dtoToEntity(OrderDTO orderDTO) {
        return Order.builder()
                .id(orderDTO.getId())
                .shippedFrom(locationConverter.dtoToEntity(orderDTO.getShippedFrom()))
                .customer(customerConverter.dtoToEntity(orderDTO.getCustomer()))
                .createdAt(orderDTO.getCreatedAt())
                .address(addressConverter.dtoToEntity(orderDTO.getAddress()))
                .build();
    }

    @Override
    public OrderDTO entityToDto(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .shippedFrom(locationConverter.entityToDto(order.getShippedFrom()))
                .customer(customerConverter.entityToDto(order.getCustomer()))
                .createdAt(order.getCreatedAt())
                .address(addressConverter.entityToDto(order.getAddress()))
                .build();
    }
}
