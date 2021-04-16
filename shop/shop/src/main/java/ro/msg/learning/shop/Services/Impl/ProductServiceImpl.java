package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Services.Interfaces.ProductService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductConverter productConverter = new ProductConverter();
    @Autowired
    private SupplierConverter supplierConverter = new SupplierConverter();

    // Read all products
    @Override
    public List<ProductDTO> getAllProducts() {
        return productConverter.convertEntityToDto(repository.findAll());
    }

    // Read product by ID
    @Override
    public ProductDTO getProduct(Integer id){
        Product product = repository.findById(id).orElse(null);
        if(product == null)
            throw new RuntimeException("No product with id " + id);
        return productConverter.entityToDto(product);
    }

    // Delete product by ID
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // Create a new product
    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productConverter.dtoToEntity(productDTO);
        repository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productConverter.dtoToEntity(productDTO);
        repository.save(product);
    }
}
