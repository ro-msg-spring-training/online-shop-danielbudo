package ro.msg.learning.shop.Services.Interfaces;

import ro.msg.learning.shop.DTOs.ProductCategoryDTO;
import ro.msg.learning.shop.Entities.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> getAllProductCategories();

    void addProductCategory(ProductCategoryDTO productCategory);
}
