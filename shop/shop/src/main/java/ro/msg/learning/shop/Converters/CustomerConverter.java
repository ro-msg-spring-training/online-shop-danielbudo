package ro.msg.learning.shop.Converters;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.CustomerDTO;
import ro.msg.learning.shop.Entities.Customer;

@Component
public class CustomerConverter extends AbstractConvertor<Customer, CustomerDTO>{

    @Override
    public Customer dtoToEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .emailAddress(customerDTO.getEmailAddress())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .username(customerDTO.getUserName())
                .build();
    }

    @Override
    public CustomerDTO entityToDto(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .emailAddress(customer.getEmailAddress())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .userName(customer.getUsername())
                .build();
    }
}
