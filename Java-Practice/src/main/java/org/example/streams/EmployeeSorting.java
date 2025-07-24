package org.example.streams;

import org.example.models.Employee;
import org.example.utils.EmployeeProducer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
Sort employees
descending order of salaries
age
name
give names
 */

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



    public static void main(String[] args) {
        sort(EmployeeProducer.generateEmployees());
    }
}
