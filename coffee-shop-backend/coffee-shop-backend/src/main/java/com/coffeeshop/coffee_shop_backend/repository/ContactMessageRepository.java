package com.coffeeshop.coffee_shop_backend.repository;

import com.coffeeshop.coffee_shop_backend.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}