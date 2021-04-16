package ro.msg.learning.shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.AbstractListenerServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.*;
import ro.msg.learning.shop.Entities.*;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Repositories.SupplierRepository;
import ro.msg.learning.shop.Services.Impl.SupplierServiceImpl;
import ro.msg.learning.shop.Services.Interfaces.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierConverter supplierConverter;
    @Autowired
    private OrderService orderService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(Integer id){
        return this.productService.getProduct(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDTO){
        this.productService.addProduct(productDTO);
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