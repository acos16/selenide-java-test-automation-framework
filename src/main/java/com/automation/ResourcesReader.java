package com.automation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesReader {

    private static final Logger log = LogManager.getLogger(ResourcesReader.class);
    private static final String DEFAULT_ENVIRONMENT = "dev";

    private ResourcesReader() {
        throw new IllegalStateException("Environment handler class");
    }

    // Method to read environment from gradle.properties
    public static String readEnvironmentFromProperties() {
        var properties = new Properties();
        String environment = null; //DEFAULT_ENVIRONMENT
        try (var input = new FileInputStream("gradle.properties")) {
            properties.load(input);
            environment = properties.getProperty("environment");
            if (environment == null || environment.isEmpty()) {
                environment = DEFAULT_ENVIRONMENT;
            }
        } catch (IOException e) {
            log.error("Error reading gradle.properties file", e);
        }
        return environment;
    }

    public static String getEnvironment() {
        String url = null;
        try (var inputStream = ResourcesReader.class.getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream == null) {
                log.error("File not found in resources.");
                return null;
            }
            var environment = System.getProperty("environment", readEnvironmentFromProperties()); // Use system property if provided
            log.info("environment {}", environment);
            var urlContainer = new ObjectMapper().readValue(inputStream, URLContainer.class);
            url = urlContainer.getUrls().get(environment);

            if (url != null) {
                log.info("URL for environment ({}): {}", environment, url);
            } else {
                log.warn("No URL found for environment: {}", environment);
            }
        } catch (IOException e) {
            log.error("Cannot read file ", e);
        }
        return url;
    }
}








