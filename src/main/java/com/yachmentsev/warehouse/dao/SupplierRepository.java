package com.yachmentsev.warehouse.dao;

import com.yachmentsev.warehouse.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}