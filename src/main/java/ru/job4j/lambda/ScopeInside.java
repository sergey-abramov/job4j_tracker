package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int rsl = 0;
        for (int num : number) {
            int finalRsl = rsl;
            rsl = add(
                    () -> finalRsl + num
            );
        }
        System.out.println(rsl);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
