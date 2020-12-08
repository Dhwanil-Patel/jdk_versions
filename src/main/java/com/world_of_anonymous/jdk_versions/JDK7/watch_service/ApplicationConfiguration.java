package com.world_of_anonymous.jdk_versions.JDK7.watch_service;

import java.io.*;
import java.util.Properties;

/**
 * A configuration provider is simply a wrapper for holding the set of properties in java,util.Properties instance.
 * It also provides methods to get the configured properties using their KEY.
 */
public class ApplicationConfiguration {

  private final static ApplicationConfiguration INSTANCE = new ApplicationConfiguration();

  public static ApplicationConfiguration getInstance() {
    return INSTANCE;
  }

  private static Properties configuration = new Properties();

  private static Properties getConfiguration() {
    return configuration;
  }

  public void initilize(final String file) {
    InputStream in = null;
    try {
      configuration.clear();
      in = new FileInputStream(new File(file));
      configuration.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getConfiguration(final String key) {
    return (String) getConfiguration().get(key);
  }

  public String getConfigurationWithDefaultValue(final String key,
                                                 final String defaultValue) {
    return (String) getConfiguration().getProperty(key, defaultValue);
  }

//  private final static ApplicationConfiguration INSTANCE = new ApplicationConfiguration();
//
//  public static ApplicationConfiguration getInstance() {
//    return INSTANCE;
//  }
//
//  private static Properties configuration = new Properties();
//
//  private static Properties getConfiguration() {
//    return configuration;
//  }
//
//  public void initialize(final String file) {
//    InputStream in = null;
//    try {
//      in = new FileInputStream(new File(file));
//      configuration.load(in);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public String getConfiguration(final String key) {
//    return (String) getConfiguration().get(key);
//  }
//
//  public String getConfigurationWithDefaultValue(final String key, final String defaultValue) {
//    return (String) getConfiguration().getProperty(key, defaultValue);
//  }
}
