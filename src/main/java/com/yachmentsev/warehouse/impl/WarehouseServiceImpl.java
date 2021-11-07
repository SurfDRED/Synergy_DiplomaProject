package com.yachmentsev.warehouse.impl;

import com.yachmentsev.warehouse.dao.WarehouseRepository;
import com.yachmentsev.warehouse.entity.Warehouse;
import com.yachmentsev.warehouse.exeption.SupplierNotFoundException;
import com.yachmentsev.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public List getAll() {
        return  warehouseRepository.findAll();
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse getID(int id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);;
        if(warehouse == null){
            throw new SupplierNotFoundException();
        }
        return warehouse;
    }



    @Override
    public void delete(int id) {
        if (warehouseRepository.existsById(id)) {
            warehouseRepository.deleteById(id);
        } else {
            throw new SupplierNotFoundException();
        }
    }
}