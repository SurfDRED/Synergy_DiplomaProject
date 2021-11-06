package com.yachmentsev.warehouse.controller;

import com.yachmentsev.warehouse.entity.Warehouse;
import com.yachmentsev.warehouse.service.WarehouseService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @Value("${welcome.message}")
    private String message;

    //первая страница
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(@NotNull Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    //страничка со списком складов
    @RequestMapping(value = { "/wh/listWh" }, method = RequestMethod.GET)
    public String warehouseList(@NotNull Model model) {
        List<Warehouse> warehouseList = warehouseService.getAllWarehouse();
        model.addAttribute("warehouseList", warehouseList);
        return "/wh/listWh";
    }



    //На страничку для создания нового склада
    @RequestMapping(value = { "/wh/addWhPage" }, method = RequestMethod.GET)
    public String addWarehouse(@NotNull Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse",warehouse);
        return "/wh/addWh";
    }

    //На страничку для изменения склада
    @GetMapping("/wh/updateWhPage/{id}")
    public String updateWarehouse(@PathVariable("id") int id, @NotNull Model model) {
        Warehouse warehouse = warehouseService.getWarehouse(id);
        model.addAttribute("warehouse", warehouse);
        return "/wh/updateWh";
    }

    //Обновляем сохранение
    @PostMapping("/saveWh")
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/wh/listWh";
    }

    //удаляем склад делая редирект на список
    @GetMapping("/wh/deleteWh/{id}")
    public String deleteWarehouse(@PathVariable("id") int id){
        warehouseService.deleteWarehouse(id);
        return "redirect:/wh/listWh";
    }
}