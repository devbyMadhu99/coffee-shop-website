package com.coffeeshop.coffee_shop_backend.repository;

import com.coffeeshop.coffee_shop_backend.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
