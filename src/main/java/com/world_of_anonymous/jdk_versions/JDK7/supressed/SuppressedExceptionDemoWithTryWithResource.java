package com.world_of_anonymous.jdk_versions.JDK7.supressed;

// Default try-with-resource block
public class SuppressedExceptionDemoWithTryWithResource {
  /**
   * Demonstrating suppressed exceptions using try-with-resources
   */
  public static void main(String[] args) throws Exception {
    try (DirtyResource resource = new DirtyResource()) {
      resource.accessResource();
    }
  }
}
