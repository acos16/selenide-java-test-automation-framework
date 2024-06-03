package com.automation.base;

import com.automation.config.EnvironmentLoader;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * BasePage contains common page functionalities that can be
 * reused across multiple pages
 */
public class BasePage {

    public static final Logger log = LogManager.getLogger(BasePage.class);

    protected BasePage() {
        Configuration.baseUrl = EnvironmentLoader.getEnvironment();
    }

    public void navigateTo(String url) {
        //todo: add implementation
    }

    @BeforeEach
    public void setUp() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterEach
    public void afterRun() {
        Selenide.closeWebDriver();
    }
}
