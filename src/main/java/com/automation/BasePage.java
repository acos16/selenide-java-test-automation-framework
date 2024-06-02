package com.automation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BasePage {

    public static final Logger log = LogManager.getLogger(BasePage.class);

    protected BasePage() {
        Configuration.baseUrl = ResourcesReader.getEnvironment();
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
