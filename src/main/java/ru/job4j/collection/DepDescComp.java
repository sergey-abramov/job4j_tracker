package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arrO1 = o1.split("/");
        String[] arrO2 = o2.split("/");
        int rsl = String.CASE_INSENSITIVE_ORDER.compare(arrO2[0], arrO1[0]);
        if (rsl == 0) {
            for (int i = 1; i < Math.min(arrO1.length, arrO2.length); i++) {
                rsl = arrO1[i].compareTo(arrO2[i]);
            }
        }
        return rsl;
    }
}
