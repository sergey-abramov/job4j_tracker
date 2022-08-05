package ru.job4j.poly;

public class Bus extends Transport {
    @Override
    boolean drive() {
        return false;
    }

    @Override
    int passengers(int passengers) {
        return passengers;
    }

    @Override
    int gas(int gas, int price) {
        return gas / price;
    }
}
