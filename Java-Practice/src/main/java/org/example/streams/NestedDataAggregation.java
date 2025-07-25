package org.example.streams;

import org.example.models.Department;
import org.example.models.Employee;
import org.example.utils.EmployeeProducer;

import java.util.List;
import java.util.stream.Collectors;


/*
Implement a system that calculates statistics on a nested list using `Stream.flatMap()` and aggregation.

Requirements:

Define a `Department` class with fields `name` and a list of `Employee` objects.
Define an `Employee` class with fields `name` and `salary`.
Create a list of departments, each having a list of employees.
Use `Stream.flatMap()` to flatten the employee list from all departments.
Compute the total salary of all employees using `Stream.reduce()` or `Collectors.summingDouble()`.
Group the employees by salary range (e.g., below 50k, 50k-100k, above 100k).
 */
public class NestedDataAggregation {

    public static void aggregate(List<Department> list){
        System.out.println(list.stream()
                .flatMap(department -> department.employees().stream())
                .collect(Collectors.groupingBy(employee -> {
                    double salary = employee.getSalary();
                    if(salary <= 50000) return "Below 50k";
                    else if(salary <= 60000) return "Below 60k";
                    else return "Below 100k";
                }, Collectors.mapping(Employee::getName, Collectors.toList()))));

    }

    public static void main(String[] args) {

        aggregate(EmployeeProducer.generateDepartments());
    }
}
