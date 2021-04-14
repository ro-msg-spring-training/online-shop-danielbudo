package ro.msg.learning.shop.Config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.msg.learning.shop.Converters.ProductCategoryConverter;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.ProductCategoryDTO;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Entities.Supplier;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter((Converter<ProductCategory, ProductCategoryDTO>) new ProductCategoryConverter());
        registry.addConverter((Converter<Product, ProductDTO>) new ProductConverter());
        registry.addConverter((Converter<Supplier, SupplierDTO>) new SupplierConverter());
    }
}
