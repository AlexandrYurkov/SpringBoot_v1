package ru.otus.alexandr.yurkov.spring.app.spring_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.alexandr.yurkov.spring.app.spring_app.entities.Item;
import ru.otus.alexandr.yurkov.spring.app.spring_app.repositories.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository = new ItemRepository();

    public Item save(Item item) {
            int id = itemRepository.findAll().size()+1;
            itemRepository.add(new Item(id, item.getTitle(), item.getPrice()));
            return itemRepository.getReferenceById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(int id) {
        return itemRepository.getReferenceById(id) != null ? itemRepository.getReferenceById(id) : null;
    }
}
