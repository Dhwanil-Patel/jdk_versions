package com.world_of_anonymous.jdk_versions.JDK8;

import java.io.InvalidObjectException;
import java.util.Optional;

public class OptionalExample {
  public static void main(String[] args) {
    
    // Create optional variable
    Optional<Object> empty = Optional.empty();
    Optional<Integer> integer = Optional.of(5);
    Optional<Object> object = Optional.ofNullable(null);

    object.ifPresent(System.out::println);

    // Default/absent values and actions
    object.orElse(new Object());
    object.orElseThrow(IllegalStateException::new);

    // Rejecting certain values using the filter method
    Optional<String> companyOptional = Optional.empty();
    companyOptional
        .filter(department -> "HR".equals(department))
        .ifPresent(s -> System.out.println("HR is present"));


  }
}
