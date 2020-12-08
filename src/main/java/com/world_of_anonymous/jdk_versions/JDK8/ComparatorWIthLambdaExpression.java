package com.world_of_anonymous.jdk_versions.JDK8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorWIthLambdaExpression {

  private static List<Employee> getEmployees(){
    List<Employee> employees  = new ArrayList<>();
    employees.add(new Employee(6, 25, "M", "Yash", "Chopra"));
    employees.add(new Employee(2, 28, "M", "Aman", "Sharma"));
    employees.add(new Employee(3, 52, "M","Aakash", "Yaadav"));
    employees.add(new Employee(5, 19, "M","David", "Kameron"));
    employees.add(new Employee(4,72, "M", "James", "Hedge"));
    employees.add(new Employee(8,88, "M", "Balaji", "Subbu"));
    employees.add(new Employee(7,59, "M", "Karan", "Johar"));
    employees.add(new Employee(1,32, "M", "Lokesh", "Gupta"));
    employees.add(new Employee(9,33, "M", "Vishu", "Bissi"));
    employees.add(new Employee(10,60, "M", "Lokesh", "Ramachandran"));
    return employees;
  }

  public static void main(String[] args) {
    List<Employee> employees  = getEmployees();

    // Sort by name
    employees.sort(Comparator.comparing(Employee::getFirstName));
    System.out.println(employees);

    // Sort by name reverse order
    employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
    System.out.println(employees);

    // Sort by multiple fields
    employees.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName));
    System.out.println(employees);

    // Parallel Sort
    Employee[] empArray = employees.toArray(new Employee[employees.size()]);
    Arrays.parallelSort(empArray, Comparator.comparing(Employee::getLastName));
    System.out.println(Arrays.toString(empArray));
  }
}
