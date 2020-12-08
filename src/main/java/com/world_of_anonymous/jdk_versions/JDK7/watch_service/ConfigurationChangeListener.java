package com.world_of_anonymous.jdk_versions.JDK7.watch_service;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Configuration Change Listener – File Watcher
 *
 * Now when we have our basic wrapper for our in-memory cache of configuration properties, we need a mechanism to reload this cache on runtime,
 * whenever configuration file stored in file system changes.
 */
public class ConfigurationChangeListener implements Runnable {

  private String configFileName = null;
  private String fullFilePath = null;

  public ConfigurationChangeListener(final String filePath) {
    this.fullFilePath = filePath;
  }

  public void run() {
    try {
      register(this.fullFilePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void register(final String file) throws IOException {
    final int lastIndex = file.lastIndexOf("/");
    String dirPath = file.substring(0, lastIndex + 1);
    String fileName = file.substring(lastIndex + 1, file.length());
    this.configFileName = fileName;

    configurationChanged(file);
    startWatcher(dirPath, fileName);
  }

  private void startWatcher(String dirPath, String file) throws IOException {
    final WatchService watchService = FileSystems.getDefault()
        .newWatchService();
    Path path = Paths.get(dirPath);
    path.register(watchService, ENTRY_MODIFY);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        try {
          watchService.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    WatchKey key = null;
    while (true) {
      try {
        key = watchService.take();
        for (WatchEvent<?> event : key.pollEvents()) {
          if (event.context().toString().equals(configFileName)) {
            configurationChanged(dirPath + file);
          }
        }
        boolean reset = key.reset();
        if (!reset) {
          System.out.println("Could not reset the watch key.");
          break;
        }
      } catch (Exception e) {
        System.out.println("InterruptedException: " + e.getMessage());
      }
    }
  }

  public void configurationChanged(final String file) {
    System.out.println("Refreshing the configuration.");
    ApplicationConfiguration.getInstance().initilize(file);
  }

//  private String configFileName = null;
//  private String fullFilePath = null;
//
//  public ConfigurationChangeListener(String filePath) {
//    this.fullFilePath = filePath;
//  }
//
//  @Override
//  public void run() {
//    try {
//      register(this.fullFilePath);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  private void register(final String file) throws IOException {
//    final int lastIndex = file.lastIndexOf("/");
//    String dirPath = file.substring(0, lastIndex + 1);
//    String fileName = file.substring(lastIndex + 1, file.length());
//    this.configFileName = fileName;
//
//    configurationChanged(file);
//    startWatcher(dirPath, fileName);
//  }
//
//  private void startWatcher(String dirPath, String fileName) throws IOException {
//    final WatchService watchService = FileSystems.getDefault().newWatchService();
//    Path path = Paths.get(dirPath);
//    path.register(watchService, ENTRY_MODIFY);
//
//    Runtime.getRuntime().addShutdownHook(new Thread() {
//      public void run() {
//        try {
//          watchService.close();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    });
//
//    WatchKey key = null;
//    while (true) {
//      try {
//        key = watchService.take();
//        for (WatchEvent<?> event : key.pollEvents()) {
//          if (event.context().toString().equals(configFileName)) {
//            configurationChanged(dirPath + fileName);
//          }
//        }
//        boolean reset = key.reset();
//        if (!reset) {
//          System.out.println("Could not reset the watch key.");
//          break;
//        }
//      } catch (Exception e) {
//        System.out.println("InterruptedException: " + e.getMessage());;
//      }
//    }
//  }
//
//  public void configurationChanged(final String file) {
//    System.out.println("Refreshing the configuration.");
//    ApplicationConfiguration.getInstance().initialize(file);
//  }
}
