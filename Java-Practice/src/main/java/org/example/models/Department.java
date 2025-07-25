package org.example.models;

import java.util.List;

public record Department(String name, List<Employee> employees) {
}
