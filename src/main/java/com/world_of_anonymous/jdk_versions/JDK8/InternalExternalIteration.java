package com.world_of_anonymous.jdk_versions.JDK8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InternalExternalIteration {
  public static void main(String[] args) {

    List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});

    // External Iteration
    for (String letter : alphabets) {
      System.out.println(letter.toUpperCase());
    }

    Iterator<String> iterator = alphabets.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toUpperCase());
    }

    // Internal Iteration
    alphabets.forEach(s -> {
      System.out.println(s.toUpperCase());
    });
  }
}
