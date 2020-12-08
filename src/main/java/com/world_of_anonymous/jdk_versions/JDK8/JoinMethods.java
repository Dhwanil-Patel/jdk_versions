package com.world_of_anonymous.jdk_versions.JDK8;

//import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoinMethods {
  public static void main(String[] args) {
    // String join(CharSequence delimiter, CharSequence... elements)
    System.out.println(String.join(", ", "How", "To", "Do", "In", "Java"));

    // String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
    String[] strArray = { "How", "To", "Do", "In", "Java" };
    String.join(",", strArray);
    String.join(",", Arrays.asList(strArray));

    // StringJoiner(CharSequence delimiter)
    // StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    joiner.add("How").add("To").add("Do").add("In").add("Java");

    // String list of string with Collectors.joining()
    System.out.println(Arrays.asList(strArray)
                        .stream()
                        .collect(Collectors.joining(",", "[", "]")));

      // Use JDK 8 for this
//    System.out.println(StringUtils.join(Arrays.asList(strArray), ","));
  }
}
