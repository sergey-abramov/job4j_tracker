package ru.job4j.poly;

public interface Transport {
     boolean drive();

     int passengers(int passengers);

     int gas(int gas, int price);
}
