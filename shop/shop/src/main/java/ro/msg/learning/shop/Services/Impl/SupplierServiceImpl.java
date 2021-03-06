package ro.msg.learning.shop.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Supplier;
import ro.msg.learning.shop.Repositories.SupplierRepository;
import ro.msg.learning.shop.Services.Interfaces.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;
    private SupplierConverter supplierConverter;

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public void addSupplier(SupplierDTO supplier) {
        repository.save(supplierConverter.dtoToEntity(supplier));
    }
}
