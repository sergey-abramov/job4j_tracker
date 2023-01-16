package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        assertThat(tracker.findAll()).isEqualTo(List.of(item, item1, item2));
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item1"));
        assertThat(tracker.findByName("item1")).isEqualTo(List.of(item1, item2));
    }

    @Test
    public void whenSaveItemAndReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item2 = tracker.add(new Item("item2"));
        tracker.replace(item2.getId(), new Item("item1"));
        assertThat(tracker.findById(item2.getId()).getName()).isEqualTo("item1");
    }

    @Test
    public void whenSaveItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId())).isEqualTo(null);
    }
}