package com.automation.pages;

import com.automation.base.BasePage;
import com.automation.config.EnvironmentLoader;
import com.automation.config.UsersLoader;
import com.automation.entity.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("#user-name");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $("#login-button");

    /**
     * This method retrieves the start page url, which is the login page
     *
     * @return base url
     */
    @Override
    public String getPageUrl() {
        return EnvironmentLoader.getEnvironment();
    }

    @Override
    public boolean isDisplayed() {
        return loginButton.exists();
    }

    /**
     * This method allows the login into a page with different users
     *
     * @param user
     */
    public void login(User user) {
        var username = UsersLoader.getStandardUser().getUsername();
        var password = UsersLoader.getStandardUser().getPassword();
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }
}
