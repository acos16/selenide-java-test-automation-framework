package com.automation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class PagesLoader {

    private static final Logger log = LogManager.getLogger(PagesLoader.class);
    private static final String CONFIG_FILE = "config.json";

    private PagesLoader() {
        throw new IllegalArgumentException("Utility class");
    }

    public static Map<String, String> loadPage() {
        Map<String, String> pages = null;
        try (var inputStream = PagesLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                log.error("File not found in resources.");
                return null;
            }
            var resourcesContainer = new ObjectMapper().readValue(inputStream, ResourcesContainer.class);
            pages = resourcesContainer.getPages();
            // pages.get("inventory");
            // pages.get("products");
        } catch (IOException e) {
            log.error("Cannot read file ", e);
        }
        return pages;
    }
}