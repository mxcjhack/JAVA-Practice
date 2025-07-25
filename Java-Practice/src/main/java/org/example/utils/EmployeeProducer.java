package org.example.utils;

import org.example.models.Department;
import org.example.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProducer {

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

    public static List<Department> generateDepartments() {
        List<Employee> employees = generateEmployees();

        List<Department> departments = new ArrayList<>();
        List<Employee> engineering = new ArrayList<>();
        List<Employee> sales = new ArrayList<>();
        List<Employee> hr = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (i % 3 == 0) {
                engineering.add(e);
            } else if (i % 3 == 1) {
                sales.add(e);
            } else {
                hr.add(e);
            }
        }

        departments.add(new Department("Engineering", engineering));
        departments.add(new Department("Sales", sales));
        departments.add(new Department("HR", hr));

        return departments;
    }
}
