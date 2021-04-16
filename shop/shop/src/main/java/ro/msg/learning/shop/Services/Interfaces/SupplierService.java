package ro.msg.learning.shop.Services.Interfaces;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Supplier;

import java.util.List;

@Component
public interface SupplierService {
    List<Supplier> getAllSuppliers();

    public void addSupplier(SupplierDTO supplier);

    public SupplierDTO searchById(Integer id);
}
