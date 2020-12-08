package com.world_of_anonymous.jdk_versions.JDK12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTeeingMethodDemo {
  public static void main(String[] args) {
    List<Employee> employeeList = Arrays.asList(
        new Employee(1, "A", 100),
        new Employee(2, "B", 200),
        new Employee(3, "C", 300),
        new Employee(4, "D", 400));

    HashMap<String, Employee> result1 = employeeList.stream().collect(
        Collectors.teeing(
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            Collectors.minBy(Comparator.comparing(Employee::getSalary)),
            (e1, e2) -> {
              HashMap<String, Employee> map = new HashMap();
              map.put("MAX", e1.get());
              map.put("MIN", e2.get());
              return map;
            }
        )
    );
    System.out.println(result1);

    HashMap<String, Object> result2 = employeeList.stream().collect(
        Collectors.teeing(
            Collectors.filtering(employee -> employee.getSalary() > 200, Collectors.toList()),
            Collectors.filtering(employee -> employee.getSalary() > 200, Collectors.counting()),
            (list, count) -> {
              HashMap<String, Object> map = new HashMap();
              map.put("list", list);
              map.put("count", count);
              return map;
            }
        ));
    System.out.println(result2);
  }
}
