package com.automation.base;

import com.automation.config.EnvironmentLoader;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

/**
 * BasePage contains common page functionalities that can be
 * reused across multiple pages
 */
public abstract class BasePage {

    public static final Logger log = LogManager.getLogger(BasePage.class);

    protected BasePage() {
        Configuration.baseUrl = EnvironmentLoader.getEnvironment();
    }

    protected abstract String getPageUrl();

    /**
     * Returns current url
     *
     * @return webdriver currentUrl
     */
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public void loadPage(String url) {
        Objects.requireNonNull(url);

        log.debug("Loading: {}", getPageUrl());
        Selenide.open(url);

        if (getCurrentUrl().equals(url)) {
            log.debug("{} was successfully loaded.", url);
        } else {
            log.info(getClass().getSimpleName(), " {} was not loaded. Url differs from expected ");
        }
    }


    public void navigateTo(String url) {
        //todo: add implementation
    }

    @BeforeEach
    public void setUp() {

        //Selenide.open();
    }

    @AfterEach
    public void afterRun() {
        Selenide.closeWebDriver();
    }
}
