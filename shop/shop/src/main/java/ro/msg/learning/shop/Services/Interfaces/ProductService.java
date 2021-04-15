package ro.msg.learning.shop.Services.Interfaces;

import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProduct(Integer id);
    void delete(Integer id);
    void addProduct(ProductDTO productDTO);
    void update(ProductDTO productDTO);
}
