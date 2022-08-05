package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean drive() {
        return false;
    }

    @Override
    public int passengers(int passengers) {
        return passengers;
    }

    @Override
    public int gas(int gas, int price) {
        return gas / price;
    }
}
