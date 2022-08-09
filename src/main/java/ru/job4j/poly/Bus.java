package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public String run() {
        return "Поехали";
    }

    @Override
    public int passengers(int passengers) {
        for (int i = 0; i < 30; i++) {
            passengers += i;
        }
        return passengers;
    }

    @Override
    public int gas(int fuel, int price) {
        return fuel / price;
    }
}
