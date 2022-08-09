package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student tp = freshman;
        Object  obj = tp;
        Object ofreshman = new Freshman();
        System.out.println(new Freshman());
        System.out.println(ofreshman);
        System.out.println(tp);
    }
}
