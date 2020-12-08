package com.world_of_anonymous.jdk_versions.JDK8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesOperations {
  public static void main(String[] args) throws IOException {

    // Read directory

    System.out.println("Regular Files");
    Files.list(Paths.get("."))
        .filter(Files::isRegularFile)
        .forEach(System.out::println);

    System.out.println("IML files");
    Files.newDirectoryStream(Paths.get("."), path -> path.toString().endsWith(".iml"))
        .forEach(System.out::println);

    System.out.println("Hidden Files");
    File[] files = new File(".").listFiles(File::isHidden);
    System.out.println(Arrays.asList(files));

    // Read Files

    // Using Stream
    Path path = Paths.get("E:\\Dhwanil\\Practice_Project\\jdk_versions\\", "jdk_versions.iml");
    try(Stream<String> lines = Files.lines(path)) {
      lines.forEach(System.out::println);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    // Using File Reader
    File file = new File("E:\\Dhwanil\\Practice_Project\\jdk_versions\\jdk_versions.iml");
    FileReader reader = new FileReader(file);
    BufferedReader br = new BufferedReader(reader);

    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
    reader.close();

    // Write Files

    // Using Stream
    Path outputFile = Paths.get("./write.txt");
    Files.write(outputFile,  Files.readAllBytes(path));

    // Using File Writer
    try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
      writer.write(String.valueOf(Files.readAllBytes(path)));
    }
  }
}
