package com.world_of_anonymous.jdk_versions.JDK7.supressed;

public class SuppressedExceptionDemoWithTryCatch {

  private static void memberFunction() throws Exception {
    try (DirtyResource resource = new DirtyResource()) {
      resource.accessResource();
    }
  }

  /**
   * Executable member function demonstrating suppressed exceptions using try-with-resources
   */
  public static void main(String[] arguments) throws Exception
  {
    try {
      memberFunction();
    }
    catch(Exception ex) {
      System.out.println("Exception encountered: " + ex.toString());
      final Throwable[] suppressedExceptions = ex.getSuppressed();
      final int numSuppressed = suppressedExceptions.length;
      if (numSuppressed > 0)
      {
        System.out.println("\tThere are " + numSuppressed + " suppressed exceptions:");
        for (final Throwable exception : suppressedExceptions)
        {
          System.out.println("\t\t" + exception.toString());
        }
      }
    }
  }
}
