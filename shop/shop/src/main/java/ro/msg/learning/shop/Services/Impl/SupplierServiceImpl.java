package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Entities.Supplier;
import ro.msg.learning.shop.Repositories.SupplierRepository;
import ro.msg.learning.shop.Services.Interfaces.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        repository.save(supplier);
    }
}
