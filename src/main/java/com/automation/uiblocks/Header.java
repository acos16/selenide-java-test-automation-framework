package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    public boolean isHeaderVisible() {
        return $("#header_container").isDisplayed();
    }

    public void clickOnCart() {
        $("#shopping_cart_container").click();
    }

    public String getCartItemCount() {
        return $(".shopping_cart_badge").getText();
    }
}
