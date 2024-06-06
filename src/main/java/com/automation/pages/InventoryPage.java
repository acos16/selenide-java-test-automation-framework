package com.automation.pages;

import com.automation.base.BasePage;
import com.automation.config.PagesLoader;
import com.automation.uiblocks.SidebarMenu;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage extends BasePage {

    private final SelenideElement title = $(".title");
    private final SidebarMenu sideBarMenu = new SidebarMenu();
    private final ElementsCollection addToCartButtons = $$("button[id^='add-to-cart']");
    private final SelenideElement shoppingCart = $(".shopping_cart_badge");

    /**
     * This method get the page's title
     *
     * @return page title
     */
    public String getPageTitle() {
        return title.getText();
    }

    /**
     * This method returns the page url. The key word "inventory is the same as specified in the json file
     * config.json
     * "pages": {
     * "inventory": "https://www.saucedemo.com/inventory.html",
     * "products": "https://saucelabs.com/products"
     * }
     */
    @Override
    public String getPageUrl() {
        return PagesLoader.loadPage().get("inventory");
    }

    @Override
    public boolean isDisplayed() {
        return $(By.className("inventory_list")).exists();
    }

    @Override
    public boolean isLoggedIn() {
        return isDisplayed();
    }

    public SidebarMenu getSideBarMenu() {
        return sideBarMenu;
    }

    public ElementsCollection getAddToCartButton() {
        return addToCartButtons;
    }

    public SelenideElement getShoppingCart() {
        return shoppingCart;
    }

    public String getItemsInShoppingCart() {
        return shoppingCart.text();
    }

}

