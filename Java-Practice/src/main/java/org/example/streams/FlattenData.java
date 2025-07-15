package org.example.streams;

/*
Flatten a nested list of objects using `Stream.flatMap()`.

Requirements:

|Define a `Student` class with fields `name` and a list of `Subject` objects.
Define a `Subject` class with a `name` field.
Create a list of `Student` objects, each having a list of subjects.
Use `Stream.flatMap()` to flatten the list of subjects from all students.
Collect the flattened subjects into a set (to ensure uniqueness).
Create a map of students to the number of subjects they are enrolled in.
 */

import org.example.models.Student;
import org.example.models.Subject;
import org.example.utils.StudentProducer;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlattenData {

    public static Set<Subject> flat(List<Student> students){
        return students.stream()
                .flatMap(student -> student.subjects().stream())
                .collect(Collectors.toSet());

    }

    public static Map<String, Integer> map(List<Student> students){
        return students.stream()
                .collect(Collectors.toMap(
                        Student::name,
                        student -> student.subjects().size()
                ));
    }

    public static void main(String[] args) {
        System.out.println(flat(StudentProducer.students));
        System.out.println(map(StudentProducer.students));
    }
}
