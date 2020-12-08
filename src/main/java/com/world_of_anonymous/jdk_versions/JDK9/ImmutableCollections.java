package com.world_of_anonymous.jdk_versions.JDK9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollections {
  public static void main(String[] args) {
    List<String> list = List.of("Dhwanil", "Patel", "Amroli");
    Set<String> set = Set.of("Dhwanil", "Patel", "Amroli");
    Map<String, String> map = Map.ofEntries(Map.entry("1", "Lokesh"), Map.entry("2", "Amit"), Map.entry("3", "Brian"));
  }
}
