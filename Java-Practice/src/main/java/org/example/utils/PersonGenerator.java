package org.example.utils;

import org.example.models.Person;

import java.util.List;

public class PersonGenerator {

    public static List<Person> generatePersons(){
        return List.of(
                new Person("ABC", 30),
                new Person("RQD", 48),
                new Person("SPE", 40),
                new Person("TOF", 60),
                new Person("UNG", 19),
                new Person("VMH", 23),
                new Person("WLI", 31),
                new Person("XKJ", 59)
        );
    }
}
