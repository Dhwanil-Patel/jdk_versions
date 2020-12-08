package com.world_of_anonymous.jdk_versions.JDK8;

import javax.swing.*;

public class LambdaExpressions {
  public static void main(String[] args) {
    // Using lambda expression to create and start a Thread in Java
    new Thread(() -> System.out.println("Thread is running")).start();

    // Using lambda expression for adding an event listener to a GUI component
    JButton button = new JButton("Submit");
    button.addChangeListener(e -> {
      System.out.println("Button Clicked");
    });
  }
}
