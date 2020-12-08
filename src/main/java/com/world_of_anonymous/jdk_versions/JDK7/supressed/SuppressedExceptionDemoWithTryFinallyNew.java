package com.world_of_anonymous.jdk_versions.JDK7.supressed;

// After suppressed exceptions support in Java 7
public class SuppressedExceptionDemoWithTryFinallyNew {
  public static void memberFunction() throws Exception {
    Throwable th = null;
    DirtyResource resource = new DirtyResource();
    try {
      resource.accessResource();
    } catch (Exception ex) {
      th = ex;
    } finally {
      try {
        resource.close();
      } catch (Exception e) {
        if (th != null) {
          e.addSuppressed(th);
          throw e;
        }
      }
    }
  }

  /**
   * Executable function demonstrating suppressed exceptions.
   */
  public static void main(String[] args) {
    try {
      memberFunction();
    } catch (Exception ex) {
      System.out.println("Exception encountered: " + ex.toString());
      final Throwable[] suppressedExceptions = ex.getSuppressed();
      final int numSuppressed = suppressedExceptions.length;
      if (numSuppressed > 0) {
        System.out.println("\tThere are " + numSuppressed + " suppressed exceptions:");
        for (final Throwable exception : suppressedExceptions) {
          System.out.println("\t\t" + exception.toString());
        }
      }
    }
  }
}
