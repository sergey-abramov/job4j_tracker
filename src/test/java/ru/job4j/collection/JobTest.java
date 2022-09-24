package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 5)
        );
        assertEquals(rsl, 1);
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobAskByName().thenComparing(new JobAskByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 7)
        );
        assertEquals(rsl, -1);
    }

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmpName = new JobAskByName();
        Job jobOne = new Job("ImplTask", 0);
        Job jobTwo = new Job("OneTwo", 7);
        int rsl = cmpName.compare(jobOne, jobTwo);

        assertEquals(rsl, -1);
    }

    @Test
    public void whenCompatorAscByPrority() {
        Comparator<Job> cmpPriority = new JobAskByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("test one", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("test one", 3)
        );
        assertEquals(rsl, 1);
    }

    @Test
    public void whenCompatorDescByPrority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("test one", 3)
        );
        assertEquals(rsl, 1);
    }
}