package com.yachmentsev.warehouse.service;


import com.yachmentsev.warehouse.entity.Warehouse;

import java.util.List;


public interface WarehouseService {
    //Возвращаем список всех складов
    List<Warehouse> getAllWarehouse();
    //Создание и изменение склада
    void saveWarehouse(Warehouse warehouse);
    //Возвращаем склад по id
    Warehouse getWarehouse(int id);
    //Удаляем склад по id
    void deleteWarehouse(int id);
}
