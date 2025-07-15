package org.example.utils;

import org.example.models.Student;
import org.example.models.Subject;

import java.util.List;

public class StudentProducer {

    public static List<Subject> allSubjects = List.of(
            new Subject("Mathematics"),
            new Subject("Physics"),
            new Subject("Chemistry"),
            new Subject("English"),
            new Subject("Computer Science"),
            new Subject("Biology")
    );


    public static List<Student> students = List.of(
            new Student("Alice", List.of(allSubjects.getFirst(), allSubjects.get(1), allSubjects.get(4)), 10),
            new Student("Bob", List.of(allSubjects.get(2), allSubjects.get(3)), 9.38),
            new Student("Charlie", List.of(allSubjects.getFirst(), allSubjects.get(3), allSubjects.get(5)), 8.12),
            new Student("Diana", List.of(allSubjects.get(1), allSubjects.get(4)), 7.6),
            new Student("Ethan", List.of(allSubjects.getFirst(), allSubjects.get(2), allSubjects.get(3)), 8.3)
    );

}
