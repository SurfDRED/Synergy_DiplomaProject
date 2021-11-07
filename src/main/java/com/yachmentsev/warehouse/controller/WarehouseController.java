package com.yachmentsev.warehouse.controller;

import com.yachmentsev.warehouse.entity.Supplier;
import com.yachmentsev.warehouse.entity.Warehouse;
import com.yachmentsev.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Value("${welcome.message}")
    private String message;

    //первая страница
    @GetMapping(value = { "/", "/index" })
    public String index(@NotNull Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    //страничка со списком складов
    @GetMapping(value = { "/warehouse/warehouseList" })
    public String warehouseList(@NotNull Model model) {
        List<Warehouse> warehouseList = warehouseService.getAll();
        model.addAttribute("warehouseList", warehouseList);
        return "/warehouse/warehouseList";
    }

    //На страничку для создания нового склада
    @GetMapping(value = { "/warehouse/warehouseAdd" })
    public String addWarehouse(@NotNull Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse",warehouse);
        return "/warehouse/warehouseAdd";
    }

    //На страничку для изменения склада
    @GetMapping("/warehouse/warehouseUpdatePage/{id}")
    public String updateWarehouse(@PathVariable("id") int id, @NotNull Model model) {
        Warehouse warehouse = warehouseService.getID(id);
        model.addAttribute("warehouse", warehouse);
        return "/warehouse/warehouseUpdate";
    }

    //Обновляем сохранение
    @PostMapping("/warehouseSavePage")
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        warehouseService.save(warehouse);
        return "redirect:/warehouse/warehouseList";
    }

    //удаляем склад делая редирект на список
    @GetMapping("/warehouse/warehouseDeletePage/{id}")
    public String deleteWarehouse(@PathVariable("id") int id){
        warehouseService.delete(id);
        return "redirect:/warehouse/warehouseList";
    }
}