package com.automation.tests.regression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.automation.base.BaseTest;
import com.automation.config.EnvironmentLoader;
import com.automation.pages.InventoryPage;
import com.automation.utils.Utils;
import org.junit.jupiter.api.Test;

/** Test class that contains tests for the inventory page functionality. */
class CartTests implements BaseTest {

  private final InventoryPage inventoryPage = new InventoryPage();

  @Test
  void verifyItemCanBeAddedToCart() {
    // Test is applicable only on dev environment
    assertEquals("dev", EnvironmentLoader.readEnvironmentFromProperties());

    // Navigate to Inventory Page
    inventoryPage.loadPage(inventoryPage.getPageUrl());

    // Get all 'Add to cart' buttons
    var addToCartButtons = inventoryPage.getAddToCartButton();
    // Assert that there are items to add
    if (addToCartButtons.size() == 0) throw new AssertionError("No items available");
    addToCartButtons.get(Utils.getRandomNumber(addToCartButtons.size())).click();

    // Assert that the cart badge shows 1 item
    assertEquals(
        "1",
        inventoryPage.getItemsInShoppingCart(),
        "Number of items in shopping cart does not match");
  }
}
