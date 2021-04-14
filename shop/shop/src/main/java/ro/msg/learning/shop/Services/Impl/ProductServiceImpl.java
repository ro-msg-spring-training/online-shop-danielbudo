package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.Supplier;
import ro.msg.learning.shop.Repositories.ProductCategoryRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Services.Interfaces.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    private ProductConverter productConverter;
    private SupplierConverter supplierConverter;

    // Read all products
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Read product by ID
    @Override
    public Product getProduct(Integer id){
        return repository.findById(id).orElse(null);
    }

    // Delete product by ID
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // Create a new product
    @Override
    public void addProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productConverter.dtoToEntity(productDTO);
        repository.save(product);
    }
}
