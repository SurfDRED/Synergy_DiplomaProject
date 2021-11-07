package com.yachmentsev.warehouse.impl;

import com.yachmentsev.warehouse.dao.SupplierRepository;
import com.yachmentsev.warehouse.entity.Supplier;
import com.yachmentsev.warehouse.exeption.SupplierNotFoundException;
import com.yachmentsev.warehouse.service.SupplierService;
import com.yachmentsev.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List getAll() {
        return  supplierRepository.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Supplier getID(int id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);;
        if(supplier == null){
            throw new SupplierNotFoundException();
        }
        return supplier;
    }



    @Override
    public void delete(int id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        } else {
            throw new SupplierNotFoundException();
        }
    }
}