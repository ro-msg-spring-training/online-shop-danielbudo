package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.CustomerConverter;
import ro.msg.learning.shop.DTOs.CustomerDTO;
import ro.msg.learning.shop.Entities.Customer;
import ro.msg.learning.shop.Repositories.CustomerRepository;
import ro.msg.learning.shop.Services.Interfaces.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerConverter.convertEntityToDto(customerRepository.findAll());
    }

    @Override
    public CustomerDTO searchById(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null) {
            throw new RuntimeException("No customer with id " + id);
        }
        return customerConverter.entityToDto(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerConverter.dtoToEntity(customerDTO);
        customerRepository.save(customer);
    }
}