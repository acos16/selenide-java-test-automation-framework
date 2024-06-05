package com.automation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * EnvironmentLoader class is used to load the environment: dev, qa, pre-prod, prod, etc. and the specific url of
 * the test instance from the configuration file
 */
public class EnvironmentLoader {
    private static final Logger log = LogManager.getLogger(EnvironmentLoader.class);
    private static final String DEFAULT_ENVIRONMENT = "dev";
    private static final String RESOURCES_CONFIG = "config.json";
    private static final String PROPERTIES = "gradle.properties";

    private EnvironmentLoader() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String readEnvironmentFromProperties() {
        var properties = new Properties();
        String environment = null;
        try (var input = new FileInputStream(PROPERTIES)) {
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
        try (var inputStream = EnvironmentLoader.class.getClassLoader().getResourceAsStream(RESOURCES_CONFIG)) {
            if (inputStream == null) {
                log.error("File not found in resources.");
                return null;
            }
            var environment = System.getProperty("environment", readEnvironmentFromProperties()); // Use system property if provided
            log.info("environment {}", environment);
            var resourcesContainer = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
            url = resourcesContainer.getUrls().get(environment);

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
