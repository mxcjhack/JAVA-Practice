package org.example.models;

import java.util.List;

public record Student(String name, List<Subject> subjects, double cgpa) {
}
