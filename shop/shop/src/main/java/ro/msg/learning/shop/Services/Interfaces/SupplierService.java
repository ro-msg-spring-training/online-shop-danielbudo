package ro.msg.learning.shop.Services.Interfaces;

import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    public void addSupplier(SupplierDTO supplier);
}
