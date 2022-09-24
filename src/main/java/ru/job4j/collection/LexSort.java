package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] o1 = (left.split("\\."));
        String[] o2 = (right.split("\\."));
        return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
    }
}
