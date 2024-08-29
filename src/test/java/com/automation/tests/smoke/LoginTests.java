package com.automation.tests.smoke;

import static org.junit.jupiter.api.Assertions.*;

import com.automation.base.BaseTest;
import com.automation.config.EnvironmentLoader;
import com.automation.config.UsersLoader;
import com.automation.entity.User;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.utils.Utils;
import org.junit.jupiter.api.Test;

/** Test class that contains tests for the Login page. */
class LoginTests implements BaseTest {

  private final LoginPage loginPage = new LoginPage();
  private final InventoryPage inventoryPage = new InventoryPage();

  private final User user = UsersLoader.getStandardUser();

  @Test
  void verifyLoginToPageIsSuccessfulWithStandardUser() {
    // Test is applicable only on dev environment
    assertEquals("dev", EnvironmentLoader.readEnvironmentFromProperties());

    loginPage.loadPage(loginPage.getPageUrl());

    loginPage.login(user);

    assertTrue(inventoryPage.isDisplayed());

    inventoryPage.getSideBarMenu().openMenu();
    inventoryPage.getSideBarMenu().logout();
  }

  @Test
  void verifyInventoryPageNotDisplayedWhenUsingInvalidUser() {
    // Test is applicable only on dev environment
    assertEquals("dev", EnvironmentLoader.readEnvironmentFromProperties());

    loginPage.loadPage(loginPage.getPageUrl());

    User invalidUser = new User();
    invalidUser.setUsername("test");
    invalidUser.setPassword(Utils.getComplexPassword());

    loginPage.login(invalidUser);

    assertFalse(inventoryPage.isDisplayed(), "The inventory page should not be displayed.");
  }
}
