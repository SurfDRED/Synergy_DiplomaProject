package com.yachmentsev.warehouse.dao;

import com.yachmentsev.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {

}