package com.coffeeshop.coffee_shop_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.coffee_shop_backend.entity.MenuItem;
import com.coffeeshop.coffee_shop_backend.service.MenuItemService;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    private final MenuItemService service;

    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<MenuItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public MenuItem getItemById(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public MenuItem addItem(@RequestBody MenuItem item) {
        return service.addItem(item);
    }

    @PutMapping("/{id}")
    public MenuItem updateItem(
            @PathVariable Long id,
            @RequestBody MenuItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "Menu item deleted successfully";
    }
}