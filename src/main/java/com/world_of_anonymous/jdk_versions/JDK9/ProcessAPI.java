package com.world_of_anonymous.jdk_versions.JDK9;

import java.util.stream.Stream;

public class ProcessAPI {
  public static void main(String[] args) {
    ProcessHandle processHandle = ProcessHandle.current();
    ProcessHandle.Info info = processHandle.info();
    System.out.println(processHandle.pid());
    System.out.println(info.command());
    System.out.println(info.arguments());
    System.out.println(info.startInstant().isPresent());

// To get the information of a new spawned process, use process.toHandle() method to get ProcessHandle instance. Rest all of things are as above.
//    String javaPrompt = ProcessUtils.getJavaCmd().getAbsolutePath();
//    ProcessBuilder processBuilder = new ProcessBuilder(javaPrompt, "-version");
//    Process process = processBuilder.inheritIO().start();
//    ProcessHandle processHandle = process.toHandle();

    // Other three options
    Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();
    System.out.println("All Process : "+allProcesses);
    Stream<ProcessHandle> children = ProcessHandle.current().children();
    System.out.println("Children : "+children);
    Stream<ProcessHandle> descendants = ProcessHandle.current().descendants();
    System.out.println("Descendants : "+descendants);
  }
}
