package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDescByNameTest {

    @Test
    public void itemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("test 2"),
                new Item("test 3"),
                new Item("test 1")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("test 3"),
                new Item("test 2"),
                new Item("test 1")
        );
        assertEquals(items, expected);
    }
}