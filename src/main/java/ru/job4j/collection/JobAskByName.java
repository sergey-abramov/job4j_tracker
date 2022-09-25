package ru.job4j.collection;

import java.util.Comparator;

public class JobAskByName implements Comparator<Job> {
    public int compare(Job o1, Job o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    }
}
