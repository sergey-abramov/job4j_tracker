package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int rsl = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int finalRsl = rsl;
            rsl = add(
                    () ->  {
                        return finalRsl + num;
                    }
            );
        }
        System.out.println(rsl);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
