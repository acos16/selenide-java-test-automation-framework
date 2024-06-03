package com.automation.tests.regression;

import com.automation.User;
import com.automation.base.BasePage;
import com.automation.config.UsersLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class FirstClassTests extends BasePage {

    private static final Logger log = LogManager.getLogger(FirstClassTests.class);

    @Test
    void firstTest() {
        //todo: add test
        Optional<User> standardUser = UsersLoader.getStandardUser();
        //assertEquals("dev", EnvironmentLoader.readEnvironmentFromProperties());
        var user = standardUser.get().getUsername();
        log.info(user);

    }

}