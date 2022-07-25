package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public final String name2 = "+ ExtraTomato ";

    public String name() {
        return super.name() + name2;
    }
}

