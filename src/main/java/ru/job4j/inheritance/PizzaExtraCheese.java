package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    public final String name1 = "+ Extra Cheese ";

    public String name() {
        return super.name() + name1;
    }
}
