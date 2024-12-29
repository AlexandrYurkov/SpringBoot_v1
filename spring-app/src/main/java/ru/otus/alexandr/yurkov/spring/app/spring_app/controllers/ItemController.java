package ru.otus.alexandr.yurkov.spring.app.spring_app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.alexandr.yurkov.spring.app.spring_app.entities.Item;
import ru.otus.alexandr.yurkov.spring.app.spring_app.service.ItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    @RequestMapping
    public List<Item> getItems() {
        return service.findAll();
    }

    @RequestMapping("/test")
    public List<Item> test() {
        for(int i = 0; i < 10; i++) {
            Item item = new Item(i, "title" + i, (i * 101));
            service.save(item);
        }
        return service.findAll();
    }

    @RequestMapping("/{id}")
    public Object getItem(@PathVariable int id) {
        return service.findById(id) != null ? service.findById(id) : "Not found";
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item) {
        return service.save(item);
    }
}
