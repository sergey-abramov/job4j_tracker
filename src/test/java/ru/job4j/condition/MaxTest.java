package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenThis33And2And15Then33() {
        int expected = 33;
        Max max = new Max();
        int rsl = max.max(33, 2, 15);
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenThis33And2And15And55Then55() {
        int expected = 55;
        Max max = new Max();
        int rsl = max.max(33, 2, 15, 55);
        assertThat(expected, is(rsl));
    }
}