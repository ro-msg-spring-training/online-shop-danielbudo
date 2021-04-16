package ro.msg.learning.shop.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Entities.Supplier;

@Component
public class ProductConverter extends AbstractConvertor<Product, ProductDTO>{
    @Autowired
    ProductCategoryConverter productCategoryConverter;
    @Autowired
    SupplierConverter supplierConverter;

    @Override
    public Product dtoToEntity(ProductDTO productDTO) {
        if(productDTO.getProductCategoryDTO().getId() == null)
            throw new RuntimeException("Category " + productDTO.getProductCategoryDTO() + " has null id.");
        if(productDTO.getSupplierDTO().getId() == null)
            throw new RuntimeException("Supplier " + productDTO.getSupplierDTO() + " has null id.");
        ProductCategory productCategory = ProductCategory.builder()
                .id(productDTO.getProductCategoryDTO().getId())
                .name(productDTO.getProductCategoryDTO().getName())
                .description(productDTO.getProductCategoryDTO().getDescription())
                .build();
        Supplier supplier = Supplier.builder()
                .id(productDTO.getSupplierDTO().getId())
                .name(productDTO.getSupplierDTO().getName())
                .build();
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .weight(productDTO.getWeight())
                .productCategory(productCategory)
                .supplier(supplier)
                .imageUrl(productDTO.getImageUrl())
                .build();
    }

    @Override
    public ProductDTO entityToDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .productCategoryDTO(productCategoryConverter.entityToDto(product.getProductCategory()))
                .supplierDTO(supplierConverter.entityToDto(product.getSupplier()))
                .imageUrl(product.getImageUrl())
                .build();
    }
}
