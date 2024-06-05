package com.automation.pages;

import com.automation.base.BasePage;
import com.automation.config.EnvironmentLoader;
import com.automation.config.UsersLoader;
import com.automation.entity.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login-button");

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

    @Override
    public boolean isLoggedIn() {
        // This is not applicable for LoginPage
        return false;
    }

    /**
     * This method allows the login into a page with different users
     *
     * @param user
     */
    public void login(User user) {
        usernameField.setValue(user.getUsername());
        passwordField.setValue(user.getPassword());
        loginButton.click();
    }

    /**
     * This method logins with standard User
     */
    public void loginAsStandardUser() {
        User standardUser = UsersLoader.getStandardUser();
        login(standardUser);
    }


}
