package com.automation.config;

import com.automation.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The UsersLoader class is responsible for loading user-related data (such as test users or credentials) from
 * the configuration file
 */
public class UsersLoader {
    private static final Logger log = LogManager.getLogger(UsersLoader.class);
    private static final String CONFIG_FILE = "config.json";

    private UsersLoader() {
        throw new IllegalArgumentException("Utility class");
    }

    public static List<User> loadUsers() {

        try (var inputStream = UsersLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                log.error("File not found in resources.");
                return Collections.emptyList();
            }
            ResourcesContainer users = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
            return users.getUsers();
        } catch (IOException e) {
            log.error("Cannot read file {}", CONFIG_FILE, e);
            return Collections.emptyList();
        }
    }

    public static Optional<User> getStandardUser() {
        List<User> users = loadUsers();
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    public static Optional<User> getVisualUser() {
        List<User> users = loadUsers();
        return users.size() < 2 ? Optional.empty() : Optional.of(users.get(1));
    }
}

