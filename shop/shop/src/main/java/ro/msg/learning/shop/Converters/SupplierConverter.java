package ro.msg.learning.shop.Converters;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTOs.SupplierDTO;
import ro.msg.learning.shop.Entities.Supplier;

// Override methods in Converter interface for conversion between Supplier and SupplierDTO
@Component
public class SupplierConverter extends AbstractConvertor<Supplier, SupplierDTO>{
    @Override
    public Supplier dtoToEntity(SupplierDTO supplierDTO) {
        return Supplier.builder()
                .id(supplierDTO.getId())
                .name(supplierDTO.getName())
                .build();
    }

    @Override
    public SupplierDTO entityToDto(Supplier supplier) {
        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .build();
    }
}
