package com.world_of_anonymous.jdk_versions.JDK7.watch_service;

/**
 * A WatchService is the JDKs internal service which watches for changes on registered objects.
 * These registered objects are necessarily the instances of Watchable interface.
 * When registering the watchable instance with WatchService, we need to specify the kind of change events we are interested in.
 *
 * There are four type of events as of now:
 *
 * ENTRY_CREATE,
 * ENTRY_DELETE,
 * ENTRY_MODIFY
 * OVERFLOW.
 *
 * WatchService interface extends Closeable interface, means service can be closed as and when required.
 * Normally, it should be done using JVM provided shut down hooks.
 *
 * Note :
 *
 * - If you are using Java 7 in your new project, and you are not using old-fashioned methods to reload your properties, you are not doing it rightly.
 * - WatchService provides two methods take() and poll(). While take() method wait for next change to happen and until it is blocked,
 *   poll() immediately check for change event.
 * - If nothing changed from last poll() call, it will return null. poll() method does not block the execution,
 *   so should be called in a Thread with some sleep time.
 */
public class WatcherMain {
  private static final String FILE_PATH = "C:\\Users\\Vasantika\\Desktop\\test.properties";
  public static void main(String[] args) {
    ConfigurationChangeListener listner = new ConfigurationChangeListener(FILE_PATH);
    try {
      new Thread(listner).start();
      while (true) {
        Thread.sleep(2000l);
        System.out.println(ApplicationConfiguration.getInstance()
            .getConfiguration("TEST_KEY"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
