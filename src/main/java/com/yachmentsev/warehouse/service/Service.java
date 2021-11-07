package com.yachmentsev.warehouse.service;

import java.util.List;

public interface Service<T> {
    //Возвращаем список всех складов
    List getAll();
    //Создание и изменение склада
    void save(T t);
    //Возвращаем склад по id
    T getID(int id);
    //Удаляем склад по id
    void delete(int id);
}