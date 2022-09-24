package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int res = Integer.compare(left.length(), right.length());
        if (res >= 0) {
            for (int i = 0; i < right.length(); i++) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
        } else if (res < 0) {
            for (int i = 0; i < left.length(); i++) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
        }
        return rsl;
    }
}
