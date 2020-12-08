package com.world_of_anonymous.jdk_versions.JDK8;

public class DefaultMethodClass implements DefaultMethodMovableInterface {
  public static void main(String[] args) {
    DefaultMethodClass methodClass = new DefaultMethodClass();

    // Disable movable method in same class
    methodClass.movable();

    // Enable movable method in same class
//    methodClass.movable();
  }

//  @Override
//  public void movable() {
//    System.out.println("Override Class method called!!!");
//  }
}
