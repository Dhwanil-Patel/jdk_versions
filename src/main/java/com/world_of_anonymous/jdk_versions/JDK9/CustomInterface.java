package com.world_of_anonymous.jdk_versions.JDK9;

public interface CustomInterface {
  // Till JAVA 7
  abstract void method1();
  // In JAVA 8
  // Not able to implement in sub class
  // Direct access using class name so sub class easily use them
  static void method2() {
    System.out.println("Method 2 Call");
  }
  default void method3() {
    System.out.println("Method 3 Call");
    method();
  }

  // In JAVA 9
  private void method() {
    System.out.println("Private Method Call");
  }
}

class CustomClass implements CustomInterface {
  @Override
  public void method1() {
    System.out.println("Method 1 Call");
  }

  // Gives an error
//  @Override
//  public void method2() {
//    System.out.println("Method 1 Call");
//  }

  public static void main(String[] args) {
      CustomInterface customInterface = new CustomClass();
      customInterface.method1();
      CustomInterface.method2();
      customInterface.method3();
  }
}
