package com.automation.uiblocks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The SidebarMenu class represents the sidebar menu in the application.
 * It provides methods to interact with the menu items.
 */
public class SidebarMenu {
    private final SelenideElement menuButton = $("#react-burger-menu-btn");
    private final SelenideElement allItemsLink = $("#inventory_sidebar_link");
    private final SelenideElement aboutLink = $("#about_sidebar_link");
    private final SelenideElement logoutLink = $("#logout_sidebar_link");
    private final SelenideElement resetAppStateLink = $("#reset_sidebar_link");

    /**
     * Opens the sidebar menu by clicking the menu button.
     */
    public void openMenu() {
        menuButton.click();
    }

    /**
     * Navigates to the "All Items" page by clicking the corresponding link in the sidebar menu.
     */
    public void goToAllItems() {
        allItemsLink.click();
    }

    /**
     * Navigates to the "About" page by clicking the corresponding link in the sidebar menu.
     */
    public void goToAbout() {
        aboutLink.click();
    }

    /**
     * Logs out of the application by clicking the logout link in the sidebar menu.
     */
    public void logout() {
        logoutLink.click();
    }

    /**
     * Resets the application state by clicking the reset link in the sidebar menu.
     */
    public void resetAppState() {
        resetAppStateLink.click();
    }
}
