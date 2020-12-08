package com.world_of_anonymous.jdk_versions.JDK8;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFunctions {
  public static void main(String[] args) {

    /**
     * Foreach :
     * - Use with Iterator, Stream and Map
     * - Stream support,
     *   forEach() : For manage input order when using sequential stream
     *   forEachOrdered() : For manage input order when using parallel stream
     */

    /*
      1. Creating Stream
     */

    Map<String, String> map = new HashMap<String, String>();
    map.put("A", "Alex");
    map.put("B", "Brian");
    map.put("C", "Charles");
    map.forEach((k, v) -> System.out.println("Key : "+ k + "Value : "+v));

    /**
     * 2. Stream
     */

    Integer[] arr = {1, 2, 3};
    Stream.of(1,2,3,4,5).forEach(integer -> System.out.println(integer));

    Stream.of(arr).forEach(integer -> System.out.println(integer));

    Arrays.asList(arr).stream().forEach(integer -> System.out.println(integer));

    Stream.generate(() -> (new Random()).nextInt(100)).limit(20).forEach(integer -> System.out.println(integer));

    // Stream iteration : Normal, Fibonacci and Fibonacci sum
    Stream.iterate(0, n -> n+1).limit(10).forEach(o -> System.out.println(o));
    Stream.iterate(new int[] {0, 1}, n -> new int[]{n[1], n[0]+n[1]})
        .limit(20)
        .map(n -> n[0])
        .forEach(x -> System.out.println(x));
    int sum = Stream.iterate(new int[] {0, 1}, n -> new int[]{n[1], n[0]+n[1]})
              .limit(20)
              .map(n -> n[0])
              .mapToInt(value -> value)
              .sum();
    System.out.println("Sum : "+sum);

    /*
      2. Stream Collector
     */

    // Using .collect(Collectors.toList()) & toArray(Integer[]::new)
    Stream<Integer> limit = Stream.generate(() -> (new Random()).nextInt(10)).distinct().limit(10);
    System.out.println(limit.collect(Collectors.toList()));
    Integer[] integers = limit.filter(i -> i % 2 == 0).toArray(Integer[]::new);
    System.out.println(Arrays.asList(integers));

    /**
     * 3. Stream Operations
     */

    // Intermediate operation
    String[] str = { "Amitabh", "Shekhar", "Aman", "Rahul", "Shahrukh", "Salman", "Yana", "Lokesh" };
    List<String> memberNames = Arrays.asList(str);

    memberNames.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));
    System.out.print("\n");
    memberNames.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
    System.out.print("\n");
    memberNames.stream().sorted().forEach(System.out::println);

    // Terminal Operation
    memberNames.forEach(System.out::println);
    System.out.print("\n");
    memberNames.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
    System.out.print("\n");
    System.out.println(memberNames.stream().anyMatch(s -> s.startsWith("A")));
    System.out.println(memberNames.stream().allMatch(s -> s.startsWith("A")));
    System.out.println(memberNames.stream().noneMatch(s -> s.startsWith("A")));
    System.out.print("\n");
    System.out.println(memberNames.stream().filter(s -> s.startsWith("A")).count());
    System.out.print("\n");
    memberNames.stream().reduce((s1, s2) -> s1 + "_" + s2).ifPresent(System.out::println);
    System.out.print("\n");
    System.out.println(memberNames.stream().filter(s -> s.startsWith("A")).findFirst().get());

    /*
      Intermediate Operation : filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip()
      Terminal Operation : forEach(), forEachOrdered(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
      Other Stream Operation : https://howtodoinjava.com/java8/java-streams-by-examples/
     */
  }
}
