package com.coffeeshop.coffee_shop_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coffeeshop.coffee_shop_backend.entity.MenuItem;
import com.coffeeshop.coffee_shop_backend.repository.MenuItemRepository;

@Service
public class MenuItemService {

    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllItems() {
        return repository.findAll();
    }

    public MenuItem getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    public MenuItem addItem(MenuItem item) {
        return repository.save(item);
    }

    public MenuItem updateItem(Long id, MenuItem item) {

        MenuItem existing = getItemById(id);

        existing.setName(item.getName());
        existing.setDescription(item.getDescription());
        existing.setPrice(item.getPrice());
        existing.setImage(item.getImage());
        existing.setCategory(item.getCategory());

        return repository.save(existing);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}