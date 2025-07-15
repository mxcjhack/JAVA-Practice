package org.example.streams;

/*
Use the `Stream.map()` function to transform a list of objects into a new list of a different type and perform multiple transformations in a pipeline.

Requirements:

Define a `Person` class with fields `name` and `age`.
Create a list of `Person` objects.
Convert the list of `Person` objects into a list of `String` objects containing only the names of people who are older than 30.
Chain multiple `map()` operations to:
First, extract the names of people who are over 30.
Then, transform the names to uppercase.
Use `Collectors.toList()` to collect the final results into a list.
Ensure that the final list of names contains unique names using `Collectors.toSet()`.
 */

import org.example.models.Person;

import java.util.List;

import static org.example.utils.PersonGenerator.generatePersons;

public class TransformingData {



    public static List<String> transform(List<Person> personList){
        return personList.stream()
                .filter(person -> person.age() > 30)
                .map(Person::name)
                .map(String::toUpperCase)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(transform(generatePersons()));
    }
}
