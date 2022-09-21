package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemAscByNameTest {

    @Test
    public void itemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("test 2"),
                new Item("test 3"),
                new Item("test 1")
        );
        List<Item> expected = Arrays.asList(
                new Item("test 1"),
                new Item("test 2"),
                new Item("test 3")
        );
        items.sort(new ItemAscByName());
        assertEquals(items, expected);
    }
}