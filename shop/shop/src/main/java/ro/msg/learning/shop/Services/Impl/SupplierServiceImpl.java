package ro.msg.learning.shop.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Converters.SupplierConverter;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Supplier;
import ro.msg.learning.shop.Repositories.SupplierRepository;
import ro.msg.learning.shop.Services.Interfaces.SupplierService;

import java.util.List;

@Service @AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository repository;
    private SupplierConverter supplierConverter;

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public void addSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierConverter.dtoToEntity(supplierDTO);
        System.out.println("1 "+ supplier.toString());
        this.repository.save(supplier);
    }

    public SupplierDTO searchById(Integer id){
        Supplier supplier = repository.findById(id).orElse(null);
        if(supplier == null) {
            throw new RuntimeException("No supplier with id " + id);
        }
        return supplierConverter.entityToDto(supplier);
    }
}
