package ru.job4j.search;

import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons1 = phones.find("Petr");
        var findPerson = new ArrayList<>();
        findPerson.addAll(persons1);
        assertThat(persons1).isEqualTo(findPerson);
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Kislovodsk");
        var findPerson = new ArrayList<>();
        findPerson.addAll(persons);
        assertThat(persons).isEqualTo(findPerson);
    }

    @Test
    public void whenFindByName1() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }
}