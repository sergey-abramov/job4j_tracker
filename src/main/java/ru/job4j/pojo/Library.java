package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book wow = new Book("WoW", 716);
        Book metro2032 = new Book("Metro2032", 1025);
        Book java8 = new Book("Java8", 712);
        Book cleancode = new Book("Clean code", 1245);
        Book[] book = new Book[4];
        book[0] = wow;
        book[1] = metro2032;
        book[2] = java8;
        book[3] = cleancode;
        for (int i = 0; i < book.length; i++) {
            Book bk = book[i];
            System.out.println(bk.getName() + " number of pages :" + bk.getNumber());
        }

        System.out.println("Book 1 = Clean code; book 4 = WoW");
        book[0] = cleancode;
        book[3] = wow;
        for (int i = 0; i < book.length; i++) {
            Book bk = book[i];
            System.out.println(bk.getName() + " number of pages :" + bk.getNumber());
        }

        System.out.println("Book only Clean code");
        for (int i = 0; i < book.length; i++) {
            Book bk = book[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " number of pages :" + bk.getNumber());
            }
        }
    }
}
