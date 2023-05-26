package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HbmTrackerTest {

    @AfterEach
    public void wipeTable() {
        try (var tracker = new HbmTracker()) {
            var list = tracker.findAll();
            for (Item i : list) {
                tracker.delete(i.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenAddNewItemAndFindByName() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.findByName("test1"), is(List.of(item)));
        }
    }

    @Test
    public void whenAddNewItemAndFindAll() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.findAll(), is(List.of(item)));
        }
    }

    @Test
    public void whenAddNewItemAndDelete() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            int id = tracker.add(item).getId();
            assertThat(tracker.delete(id), is(true));
        }
    }

    @Test
    public void whenAddNewItemAndReplace() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            int id = tracker.add(item).getId();
            item.setName("test2");
            assertThat(tracker.replace(id, item), is(true));
            assertThat(tracker.findAll(), is(List.of(item)));
        }
    }
}