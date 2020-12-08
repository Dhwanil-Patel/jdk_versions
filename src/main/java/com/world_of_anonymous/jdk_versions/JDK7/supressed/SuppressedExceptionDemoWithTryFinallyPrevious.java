package com.world_of_anonymous.jdk_versions.JDK7.supressed;

// Before suppressed exceptions feature
public class SuppressedExceptionDemoWithTryFinallyPrevious {

  public static void memberFunction() throws Exception {
    DirtyResource resource = new DirtyResource();
    try {
      resource.accessResource();
    } finally {
      resource.close();
    }
  }

  public static void main(String[] args) {
    try {
      memberFunction();
    } catch (Exception ex) {
      System.out.println("Exception encountered: " + ex.toString());
      final Throwable[] suppressedExcetpions = ex.getSuppressed();
      final int numSuppressed = suppressedExcetpions.length;
      if (numSuppressed > 0) {
        System.out.println("\tThere are " + numSuppressed + "suppressed exceptions : ");
        for (final Throwable exception : suppressedExcetpions) {
          System.out.println("\t\t"+exception.toString());
        }
      }
    }
  }
}
