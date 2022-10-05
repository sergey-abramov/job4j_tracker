package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> test1 = c -> c.getPhone().contains(key);
        Predicate<Person> test2 = c -> c.getSurname().contains(key);
        Predicate<Person> test3 = c -> c.getName().contains(key);
        Predicate<Person> test4 = c -> c.getAddress().contains(key);
        Predicate<Person> combine = test1.or(test2.or(test3.or(test4)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
            result.add(person);
            }
        }
        return result;
    }
}
