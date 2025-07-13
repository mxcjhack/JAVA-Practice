package org.example.streams;

import org.example.models.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSorting {

    public static void sort(List<Employee> list){
        List<String> result = list.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getAge)
                        .thenComparing(Employee::getName))
                .map(Employee::getName)
                .toList();

        for(String employee : result){
            System.out.println(employee);
        }
    }

    public static List<Employee> generateEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Alice", 30, 50000));
        list.add(new Employee("Bob", 25, 60000));
        list.add(new Employee("Charlie", 30, 50000));  // same age and salary
        list.add(new Employee("Alice", 28, 70000));     // same name
        list.add(new Employee("David", 25, 80000));     // same age
        list.add(new Employee("Eve", 32, 50000));       // same salary
        list.add(new Employee("Frank", 28, 70000));     // same age and salary
        list.add(new Employee("Grace", 25, 90000));     // same age
        list.add(new Employee("Bob", 35, 60000));       // same name and salary
        list.add(new Employee("Hank", 30, 70000));      // same age

        return list;
    }

    public static void main(String[] args) {
        sort(generateEmployees());
    }
}
