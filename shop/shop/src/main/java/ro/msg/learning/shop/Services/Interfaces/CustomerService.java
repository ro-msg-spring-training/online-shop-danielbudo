package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.CustomerDTO;
import ro.msg.learning.shop.Entities.Customer;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO searchById(Integer id);
    void delete(Integer id);
    void addCustomer(CustomerDTO customerDTO);
}