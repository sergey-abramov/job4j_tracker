package ru.job4j.bank;
/**
 * Класс описывает объект User
 * @ author Sergey Abramov
 * @ version 1.0
 */

import java.util.Objects;

public class User {
    /**
     * Поля объекта User, с помощью модификатора private
     * обеспечивают инкапсуляцию
     */
    private String passport;
    private String username;

    /**
     * Вызов полей класса User
     * @param passport применяет string значение полю passport
     * @param username применяет string значение полю username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * геттер поля passport
     * @return - вызывает его значение
     */
    public String getPassport() {
        return passport;
    }

    /**
     * сеттер поля passport
     * @param passport служит для замены значения поля
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals, служит для сравнения объектов
     * @param o - это объект, в данном случае объект класса User
     * @return - сравнивает объекты, по полям passport
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Тоже метод для сравнения объектов,
     * возвращает для любого объекта 32-битное число типа
     * и сравнивает их
     * @return - сравнивает полем объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
