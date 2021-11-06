package com.yachmentsev.warehouse.service;

import com.yachmentsev.warehouse.dao.WarehouseRepository;
import com.yachmentsev.warehouse.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAllWarehouse() {
        return  warehouseRepository.findAll();
    }

    @Override
    public void saveWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse getWarehouse(int id) {
        Warehouse warehouse = null;
        Optional<Warehouse> optional = warehouseRepository.findById(id);
        if(optional.isPresent()){
            warehouse = optional.get();
        }
        return warehouse;
    }

    @Override
    public void deleteWarehouse(int id) {
        warehouseRepository.deleteById(id);
    }
}