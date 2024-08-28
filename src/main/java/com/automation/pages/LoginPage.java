package com.automation.pages;

import static com.codeborne.selenide.Selenide.$;

import com.automation.base.BasePage;
import com.automation.config.EnvironmentLoader;
import com.automation.config.UsersLoader;
import com.automation.entity.User;
import com.codeborne.selenide.SelenideElement;

/**
 * The LoginPage class represents the login page of the application. It extends the {@link BasePage}
 * class and provides methods to interact with the login page elements.
 */
public class LoginPage extends BasePage {
  private final SelenideElement usernameField = $("#user-name");
  private final SelenideElement passwordField = $("#password");
  private final SelenideElement loginButton = $("#login-button");

  /**
   * Retrieves the start page url, which is the login page
   *
   * @return the base URL
   */
  @Override
  public String getPageUrl() {
    return EnvironmentLoader.getEnvironment();
  }

  /**
   * Checks if the login page is displayed by verifying the existence of the login button.
   *
   * @return true if the login page is displayed, false otherwise.
   */
  @Override
  public boolean isDisplayed() {
    return loginButton.exists();
  }

  /**
   * Checks if the user is logged in.
   *
   * <p>This method is not applicable for the login page and always returns false.
   *
   * @return false, as this is not applicable for the login page.
   */
  @Override
  public boolean isLoggedIn() {
    // This is not applicable for LoginPage
    return false;
  }

  /**
   * Logs into the application with the given user credentials.
   *
   * @param user the user object containing username and password.
   */
  public void login(User user) {
    usernameField.setValue(user.getUsername());
    passwordField.setValue(user.getPassword());
    loginButton.click();
  }

  /** Logs into the application with the standard user credentials. */
  public void loginAsStandardUser() {
    User standardUser = UsersLoader.getStandardUser();
    login(standardUser);
  }
}
