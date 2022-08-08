package ru.job4j.poly;

public interface Transport {
    boolean run();

    int passengers(int passengers);

    int gas(int gas, int price);
}
