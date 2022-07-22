package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово." + eng;
    }

    public static void main(String[] args) {
        DummyDic leng = new DummyDic();
        String voice = leng.engToRus("Ахалаймахалай");
        System.out.println(voice);
    }
}
