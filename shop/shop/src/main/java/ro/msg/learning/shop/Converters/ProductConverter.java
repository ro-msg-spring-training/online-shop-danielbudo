package ro.msg.learning.shop.Converters;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Entities.Supplier;

@Component
public class ProductConverter extends AbstractConvertor<Product, ProductDTO>{

    @Override
    public Product dtoToEntity(ProductDTO productDTO) {
        ProductCategory productCategory = ProductCategory.builder()
                .id(productDTO.getCategoryId())
                .name(productDTO.getCategoryName())
                .description(productDTO.getCategoryDescription())
                .build();
        Supplier supplier = Supplier.builder()
                .id(productDTO.getSupplierId())
                .name(productDTO.getSupplierName())
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
                .categoryId(product.getProductCategory().getId())
                .categoryName(product.getProductCategory().getName())
                .categoryDescription(product.getProductCategory().getDescription())
                .supplierId(product.getSupplier().getId())
                .supplierName(product.getSupplier().getName())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
