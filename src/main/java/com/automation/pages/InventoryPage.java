package com.automation.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.automation.base.BasePage;
import com.automation.config.PagesLoader;
import com.automation.uiblocks.Header;
import com.automation.uiblocks.SidebarMenu;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

/**
 * The InventoryPage class represents the inventory page of the application. It extends the {@link
 * BasePage} class and provides methods to interact with the inventory page elements.
 */
public class InventoryPage extends BasePage {

  private final SelenideElement title = $(".title");
  private final SidebarMenu sideBarMenu = new SidebarMenu();
  private final ElementsCollection addToCartButtons = $$("button[id^='add-to-cart']");
  private final SelenideElement shoppingCart = $(".shopping_cart_badge");
  private final Header header = new Header();

  /**
   * Gets the page's title
   *
   * @return page title
   */
  public String getPageTitle() {
    return title.getText();
  }

  /**
   * Returns the URL of the inventory page.
   *
   * <p>The keyword "inventory" is specified in the JSON configuration file (config.json):
   *
   * <pre>
   * {
   *   "pages": {
   *     "inventory": "https://www.saucedemo.com/inventory.html",
   *     "products": "https://saucelabs.com/products"
   *   }
   * }
   * </pre>
   *
   * @return the URL of the inventory page.
   */
  @Override
  public String getPageUrl() {
    return PagesLoader.loadPage().get("inventory");
  }

  /**
   * Checks if the inventory page is displayed by verifying the presence of the inventory list
   * element.
   *
   * @return true if the inventory page is displayed, false otherwise.
   */
  @Override
  public boolean isDisplayed() {
    return $(By.className("inventory_list")).exists();
  }

  /**
   * Checks if the user is logged in by verifying if the inventory page is displayed.
   *
   * @return true if the user is logged in, false otherwise.
   */
  @Override
  public boolean isLoggedIn() {
    return isDisplayed();
  }

  /**
   * Gets the sidebar menu of the inventory page.
   *
   * @return the sidebar menu.
   */
  public SidebarMenu getSideBarMenu() {
    return sideBarMenu;
  }

  /**
   * Gets the collection of "Add to Cart" buttons on the inventory page.
   *
   * @return the collection of "Add to Cart" buttons.
   */
  public ElementsCollection getAddToCartButton() {
    return addToCartButtons;
  }

  /**
   * Gets the shopping cart element on the inventory page.
   *
   * @return the shopping cart element.
   */
  public SelenideElement getShoppingCart() {
    return shoppingCart;
  }

  /**
   * Gets the text representing the number of items in the shopping cart.
   *
   * @return the text representing the number of items in the shopping cart.
   */
  public String getItemsInShoppingCart() {
    return header.getCartItemCount();
  }
}
