package com.world_of_anonymous.jdk_versions.JDK8;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferenceExample {
  public static void main(String[] args) {

    System.out.println("Method reference to static method – Class::staticMethodName");
    List<Integer> integers = Arrays.asList(1,12,433,5);
    Optional<Integer> data = integers.stream().reduce(Math::max);

    System.out.println("Method reference to instance method from instance – ClassInstance::instanceMethodName");
    data.ifPresent(System.out::println);

    System.out.println("Method reference to instance method from class type – Class::instanceMethodName");
    List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
    List<String> collect = strings.stream()
        // .sorted((s1, s2) -> s1.compareTo(s2))
        .sorted(String::compareTo)
        .collect(Collectors.toList());
    System.out.println(collect);

    System.out.println("Reference to constructor – Class::new");
    Optional<Integer> reduce = IntStream.range(0, 100)
        .boxed()
        .collect(Collectors.toCollection(ArrayDeque::new))
        .stream()
        .reduce(Math::max);
    reduce.ifPresent(System.out::println);
  }
}
