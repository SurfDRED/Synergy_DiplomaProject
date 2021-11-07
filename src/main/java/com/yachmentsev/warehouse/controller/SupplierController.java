package com.yachmentsev.warehouse.controller;

import com.yachmentsev.warehouse.entity.Supplier;
import com.yachmentsev.warehouse.entity.Warehouse;
import com.yachmentsev.warehouse.service.SupplierService;
import com.yachmentsev.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @Value("${welcome.message}")
    private String message;

    //первая страница
   // @GetMapping(value = { "/", "/index" })
   // public String index(@NotNull Model model) {
   //     model.addAttribute("message", message);
    //    return "index";
   // }

    //страничка со списком складов
    @GetMapping(value = { "/supplier/supplierList" })
    public String supplierList(@NotNull Model model) {
        List<Supplier> suppliersList = supplierService.getAll();
        model.addAttribute("suppliersList", suppliersList);
        return "/supplier/supplierList";
    }

    //На страничку для создания нового склада
    @GetMapping(value = { "/supplier/supplierAdd" })
    public String addSupplier(@NotNull Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier",supplier);
        return "/supplier/supplierAdd";
    }

    //На страничку для изменения склада
    @GetMapping("/supplier/supplierUpdatePage/{id}")
    public String updateSupplier(@PathVariable("id") int id, @NotNull Model model) {
        Supplier supplier = supplierService.getID(id);
        model.addAttribute("supplier", supplier);
        return "/supplier/supplierUpdate";
    }

    //Обновляем сохранение
    @PostMapping("/supplierSavePage")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier/supplierList";
    }

    //удаляем склад делая редирект на список
    @GetMapping("/supplier/supplierDeletePage/{id}")
    public String deleteSupplier(@PathVariable("id") int id){
        supplierService.delete(id);
        return "redirect:/supplier/supplierList";
    }
}