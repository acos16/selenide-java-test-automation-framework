package com.automation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** This class is responsible for loading page configuration from a configuration file. */
public class PagesLoader {

  private static final Logger log = LogManager.getLogger(PagesLoader.class);
  private static final String CONFIG_FILE = "config.json";

  /**
   * Private constructor to avoid instantiation of this utility class
   *
   * @throws IllegalArgumentException if an attempt is made to instantiate the class.
   */
  private PagesLoader() {
    throw new IllegalArgumentException("Utility class");
  }

  /**
   * Loads the page configuration from the config file.
   *
   * @return a map of page names.
   */
  public static Map<String, String> loadPage() {
    Map<String, String> pages = null;
    try (var inputStream = PagesLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
      if (inputStream == null) {
        log.error("File not found in resources.");
        return null;
      }
      var resourcesContainer = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
      pages = resourcesContainer.getPages();
    } catch (IOException e) {
      log.error("Cannot read file ", e);
    }
    return pages;
  }
}
