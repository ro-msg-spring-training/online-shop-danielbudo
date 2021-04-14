package ro.msg.learning.shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.AbstractListenerServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Services.Interfaces.ProductService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductConverter productConverter;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        // Use converter to return a list of DTOs from a list of entities
        return this.
                productConverter.convertEntityToDto(
                productService.getAllProducts()
        );
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(Integer id){
        // Use the other method to convert a single entity to a DTO
        return this.
                productConverter.entityToDto(
                productService.getProduct(id)
        );
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDTO){
        this.productService.addProduct(productConverter.dtoToEntity(productDTO));
        return new ResponseEntity<>("Product successfully added", HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.delete(id);
    }

    @PutMapping("products/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        this.productService.update(productDTO);
    }
}
