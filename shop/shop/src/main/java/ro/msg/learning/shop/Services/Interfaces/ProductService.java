package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(Integer id);
    void delete(Integer id);
    void addProduct(ProductDTO productDTO);
    void update(ProductDTO productDTO);
}
