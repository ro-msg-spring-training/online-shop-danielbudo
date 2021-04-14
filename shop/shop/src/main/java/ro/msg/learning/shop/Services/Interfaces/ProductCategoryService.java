package ro.msg.learning.shop.Services.Interfaces;

import ro.msg.learning.shop.Entities.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(ProductCategory productCategory);
}
