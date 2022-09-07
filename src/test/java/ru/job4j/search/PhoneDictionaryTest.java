package ru.job4j.search;

import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        ArrayList<Person> findPerson = new ArrayList<>();
        findPerson.addAll(persons);
        assertThat(persons).isEqualTo(findPerson);
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Kislovodsk");
        ArrayList<Person> findPerson = new ArrayList<>();
        findPerson.addAll(persons);
        assertThat(persons).isEqualTo(findPerson);
    }
}