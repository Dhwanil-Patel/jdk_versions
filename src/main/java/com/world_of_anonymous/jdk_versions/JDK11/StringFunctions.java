package com.world_of_anonymous.jdk_versions.JDK11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StringFunctions {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("E:\\Dhwanil\\Practice_Project\\jdk_versions\\temp.txt");
    String str = "I am Dhwanil Patel";
    Files.writeString(path, str, StandardOpenOption.TRUNCATE_EXISTING);
    String s = Files.readString(path);
    System.out.println(s);
  }
}
