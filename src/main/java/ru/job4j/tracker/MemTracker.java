package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item keys : items) {
            if (keys.getName().equals(key)) {
                rsl.add(keys);
            }
        }
       return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rslValidation = index != -1;
        if (rslValidation) {
            item.setId(id);
            items.set(index, item);
        }
        return rslValidation;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rslValidation = index != -1;
        if (rslValidation) {
            items.remove(index);
        }
        return rslValidation;
    }

    @Override
    public void close() {

    }
}