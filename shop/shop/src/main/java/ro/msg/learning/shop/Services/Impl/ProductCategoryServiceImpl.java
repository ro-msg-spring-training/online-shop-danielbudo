package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Repositories.ProductCategoryRepository;
import ro.msg.learning.shop.Services.Interfaces.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return repository.findAll();
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) {
        repository.save(productCategory);
    }
}
