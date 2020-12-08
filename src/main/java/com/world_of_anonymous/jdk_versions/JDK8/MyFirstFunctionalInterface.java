package com.world_of_anonymous.jdk_versions.JDK8;
import java.lang.*;

@FunctionalInterface
public interface MyFirstFunctionalInterface {
  void firstWork();
  // Gives an error when try to add another abstract method
  // void doSomeMoreWork();
}
