package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает объект Account
 * @ author Sergey Abramov
 * @ version 1.0
 */
public class Account {
    /**
     * Поля объекта Account
     */
    private String requisite;
    private double balance;

    /**
     *
     * @param requisite - применяет String значение полю requisite
     * @param balance - применяет double значение полю balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля requisite
     * @return
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля requisite
     * @param requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер поля balance
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля balance
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals, служит для сравнения объектов
     * @param o - это объект, в данном случае объект класса User
     * @return - сравнивает объекты, по полям requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Тоже метод для сравнения объектов,
     * возвращает для любого объекта 32-битное число типа
     * и сравнивает их
     * @return - сравнивает полем объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
