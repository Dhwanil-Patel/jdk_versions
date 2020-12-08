package com.world_of_anonymous.jdk_versions.JDK8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexToPredicate {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("^(.+)@example.com$");
    Predicate<String> regexEmailPredicate = pattern.asPredicate();
    List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");
    emails.stream()
        .filter(regexEmailPredicate)
        .forEach(System.out::println);

    // Using Matcher
//    for (String email : emails) {
//      Matcher matcher = pattern.matcher(email);
//      if (matcher.matches()) {
//        System.out.println(email);
//      }
//    }
  }
}
