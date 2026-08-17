package com.coffeeshop.coffee_shop_backend.controller;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coffeeshop.coffee_shop_backend.entity.ContactMessage;
import com.coffeeshop.coffee_shop_backend.service.ContactMessageService;
@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactMessageController {

    private final ContactMessageService service;

    public ContactMessageController(ContactMessageService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/{id}")
    public ContactMessage getMessageById(@PathVariable Long id) {
        return service.getMessageById(id);
    }

    @PostMapping
    public ContactMessage addMessage(@RequestBody ContactMessage message) {
        return service.addMessage(message);
    }

    @PutMapping("/{id}")
    public ContactMessage updateMessage(
            @PathVariable Long id,
            @RequestBody ContactMessage message) {
        return service.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable Long id) {
        service.deleteMessage(id);
        return "Contact message deleted successfully";
    }
}
