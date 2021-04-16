package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.ProductCategoryDTO;
import ro.msg.learning.shop.Entities.ProductCategory;

import java.util.List;

@Component
public interface ProductCategoryService {
    List<ProductCategoryDTO> getAllProductCategories();

    void addProductCategory(ProductCategoryDTO productCategory);

    public ProductCategoryDTO searchById(Integer id);
}
