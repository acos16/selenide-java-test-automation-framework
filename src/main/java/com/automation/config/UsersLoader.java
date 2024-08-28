package com.automation.config;

import com.automation.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The UsersLoader class is responsible for loading user-related data (such as test users or
 * credentials) from the configuration file
 */
public class UsersLoader {
  private static final Logger log = LogManager.getLogger(UsersLoader.class);
  private static final String CONFIG_FILE = "config.json";

  /**
   * Private constructor to avoid instantiation of this utility class.
   *
   * @throws IllegalArgumentException if an attempt is made to instating this class.
   */
  private UsersLoader() {
    throw new IllegalArgumentException("Utility class");
  }

  /**
   * Loads the list of User objects from the configuration file.
   *
   * @return a list of User objects.
   */
  public static List<User> loadUsers() {

    try (var inputStream = UsersLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
      if (inputStream == null) {
        log.error("File not found in resources.");
        return Collections.emptyList();
      }
      var users = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
      return users.getUsers();
    } catch (IOException e) {
      log.error("Cannot read file {}", CONFIG_FILE, e);
      return Collections.emptyList();
    }
  }

  /**
   * Retrieves the standard user from the list of users.
   *
   * @return the first User object in the list of users.
   * @throws NullPointerException if the list of users is null.
   */
  public static User getStandardUser() {
    List<User> users = loadUsers();
    Objects.requireNonNull(users);
    return users.get(0);
  }

  /**
   * Retrieves the visual user from the list of users.
   *
   * @return the second User object in the list of users.
   * @throws IndexOutOfBoundsException if the list of users contains fewer users than expected.
   */
  public static User getVisualUser() {
    List<User> users = loadUsers();
    Objects.requireNonNull(users);
    if (users.size() < 2) throw new IndexOutOfBoundsException();
    return users.get(1);
  }
}
