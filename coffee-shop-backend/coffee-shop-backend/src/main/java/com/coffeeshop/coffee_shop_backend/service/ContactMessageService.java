package com.coffeeshop.coffee_shop_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coffeeshop.coffee_shop_backend.entity.ContactMessage;
import com.coffeeshop.coffee_shop_backend.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public List<ContactMessage> getAllMessages() {
        return repository.findAll();
    }

    public ContactMessage getMessageById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
    }

    public ContactMessage addMessage(ContactMessage message) {
        return repository.save(message);
    }

    public ContactMessage updateMessage(Long id, ContactMessage message) {

        ContactMessage existingMessage = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));

        existingMessage.setName(message.getName());
        existingMessage.setEmail(message.getEmail());
        existingMessage.setSubject(message.getSubject());
        existingMessage.setMessage(message.getMessage());

        return repository.save(existingMessage);
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }
}