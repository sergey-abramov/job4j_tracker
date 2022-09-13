package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
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

    public Item[] findAll() {
        return items.toArray(new Item[0]);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.size()];
        int count = 0;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                rsl[count++] = item;
            }
        }
       return Arrays.copyOf(rsl, count);
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
}