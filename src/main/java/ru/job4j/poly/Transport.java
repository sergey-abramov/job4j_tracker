package ru.job4j.poly;

public interface Transport {
    String run();

    int passengers(int passengers);

    int gas(int fuel, int price);
}
