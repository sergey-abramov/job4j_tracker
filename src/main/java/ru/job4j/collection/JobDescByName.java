package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int rsl = o2.getName().compareTo(o1.getName());
        if (rsl < 0) {
            rsl = -1;
        } else if (rsl > 0) {
            rsl = 1;
        }
        return rsl;
    }
}
