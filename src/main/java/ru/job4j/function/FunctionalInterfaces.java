package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = map::put;
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        Predicate<Integer> pred = (in) -> in % 2 == 0 || map.get(in).length() == 4;
        for (Integer i : map.keySet()) {
           if (pred.test(i)) {
               System.out.println("key: " + i + "; value: " + map.get(i));
           }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        con.accept(func.apply(String.valueOf(sup)));
    }
}
