package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predPhone = c -> c.getPhone().contains(key);
        Predicate<Person> predSurname = c -> c.getSurname().contains(key);
        Predicate<Person> predName = c -> c.getName().contains(key);
        Predicate<Person> predAddress = c -> c.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predAddress.or(predPhone.or(predSurname)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
            result.add(person);
            }
        }
        return result;
    }
}
