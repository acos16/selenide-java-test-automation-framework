package com.automation.uiblocks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SidebarMenu {
    private final SelenideElement menuButton = $("#react-burger-menu-btn");
    private final SelenideElement allItemsLink = $("#inventory_sidebar_link");
    private final SelenideElement aboutLink = $("#about_sidebar_link");
    private final SelenideElement logoutLink = $("#logout_sidebar_link");
    private final SelenideElement resetAppStateLink = $("#reset_sidebar_link");

    public void openMenu() {
        menuButton.click();
    }

    public void goToAllItems() {
        allItemsLink.click();
    }

    public void goToAbout() {
        aboutLink.click();
    }

    public void logout() {
        logoutLink.click();
    }

    public void resetAppState() {
        resetAppStateLink.click();
    }
}
