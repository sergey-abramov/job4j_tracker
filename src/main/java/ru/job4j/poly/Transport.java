package ru.job4j.poly;

public abstract class Transport {
    abstract boolean drive();

    abstract int passengers(int passengers);

    abstract int gas(int gas, int price);
}
