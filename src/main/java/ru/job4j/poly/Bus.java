package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public boolean run() {
        return false;
    }

    @Override
    public int passengers(int passengers) {
        return 0;
    }

    @Override
    public int gas(int gas, int price) {
        return 0;
    }
}
