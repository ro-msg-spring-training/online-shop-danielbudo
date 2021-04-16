package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.ProductCategoryConverter;
import ro.msg.learning.shop.DTOs.ProductCategoryDTO;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Repositories.ProductCategoryRepository;
import ro.msg.learning.shop.Services.Interfaces.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Autowired
    private ProductCategoryConverter productCategoryConverter = new ProductCategoryConverter();

    @Override
    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryConverter.convertEntityToDto(repository.findAll());
    }

    @Override
    public void addProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory =productCategoryConverter.dtoToEntity(productCategoryDTO);
        repository.save(productCategory);
    }

    @Override
    public ProductCategoryDTO searchById(Integer id) {
        ProductCategory productCategory = repository.findById(id).orElse(null);
        if(productCategory == null)
            throw new RuntimeException("No product category with id " + id);
        return productCategoryConverter.entityToDto(productCategory);
    }


}
