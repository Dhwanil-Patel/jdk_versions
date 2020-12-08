package com.world_of_anonymous.jdk_versions.JDK8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java a boxed stream is a stream of the wrapper class instances to simulate a stream of primitives
 */
public class BoxedStream {

  public static void main(String[] args) {


    // Convert a stream of objects to a collection then we can use one of the static methods in the Collectors class.
    List<String> strings = Stream.of("how", "to", "do", "in", "java")
        .collect(Collectors.toList());

    // This not work
    //  IntStream.of("how", "to", "do", "in", "java")
    //      .collect(Collectors.toList());

    // For solve above
    //Get the collection and later convert to stream to process elements
    List<Integer> ints = IntStream.of(1, 2, 3, 4, 5)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(ints);

    //Stream operations directly
    Optional<Integer> max = IntStream.of(1, 2, 3, 4, 5)
        .boxed()
        .max(Integer::compareTo);
    System.out.println(max);

    //Same thing work for DoubleStream.of() and LongStreamOf()
  }
}
