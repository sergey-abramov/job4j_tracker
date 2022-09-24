package ru.job4j.collection;

import java.util.Comparator;

public class JobAskByName implements Comparator<Job> {
    public int compare(Job o1, Job o2) {
        int rsl = o1.getName().compareTo(o2.getName());
        if (rsl < 0) {
            rsl = -1;
        } else if (rsl > 0) {
            rsl = 1;
        }
        return rsl;
    }
}
