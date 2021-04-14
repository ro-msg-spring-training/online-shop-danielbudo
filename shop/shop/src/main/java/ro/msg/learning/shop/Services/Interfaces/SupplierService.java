package ro.msg.learning.shop.Services.Interfaces;

import ro.msg.learning.shop.Entities.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    void addSupplier(Supplier supplier);
}
