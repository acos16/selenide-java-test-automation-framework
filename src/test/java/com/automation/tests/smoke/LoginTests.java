package com.automation.tests.smoke;

import com.automation.base.IBaseTest;
import com.automation.config.EnvironmentLoader;
import com.automation.config.UsersLoader;
import com.automation.entity.User;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTests implements IBaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    private final User user = UsersLoader.getStandardUser();

    @Test
    void verifyLoginToPageIsSuccessfulWithStandardUser() {
        assertEquals("dev", EnvironmentLoader.readEnvironmentFromProperties());
        loginPage.loadPage(loginPage.getPageUrl());
        loginPage.loginAs(user);
        assertEquals("Products", inventoryPage.getPageTitle());
    }

}