package com.automation.config;

import com.automation.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
            var users = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
            return users.getUsers();
        } catch (IOException e) {
            log.error("Cannot read file {}", CONFIG_FILE, e);
            return Collections.emptyList();
        }
    }

    public static User getStandardUser() {
        List<User> users = loadUsers();
        Objects.requireNonNull(users);
        return users.get(0);
    }

    public static User getVisualUser() {
        List<User> users = loadUsers();
        Objects.requireNonNull(users);
        if (users.size() < 2) throw new IndexOutOfBoundsException();
        return users.get(1);
    }
}

