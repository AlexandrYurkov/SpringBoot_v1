package ru.otus.alexandr.yurkov.spring.app.spring_app.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.alexandr.yurkov.spring.app.spring_app.entities.Item;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Data
public class ItemRepository {
    private List<Item> list;

    public ItemRepository(){
        list = new ArrayList<>();
    }

    public void add(Item item) {
        list.add(item);
    }

    public List<Item> findAll() {
        return list;
    }

    public Item getReferenceById(int id) {
        return list.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }
}
