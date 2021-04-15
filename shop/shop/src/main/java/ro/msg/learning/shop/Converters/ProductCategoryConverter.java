package ro.msg.learning.shop.Converters;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.ProductCategoryDTO;
import ro.msg.learning.shop.Entities.ProductCategory;

@Component
public class ProductCategoryConverter extends AbstractConvertor<ProductCategory, ProductCategoryDTO>{

    @Override
    public ProductCategory dtoToEntity(ProductCategoryDTO productCategoryDTO) {
        return ProductCategory.builder()
                .id(productCategoryDTO.getId())
                .name(productCategoryDTO.getName())
                .description(productCategoryDTO.getDescription())
                .build();
    }

    @Override
    public ProductCategoryDTO entityToDto(ProductCategory productCategory) {
        return ProductCategoryDTO.builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .build();
    }
}
