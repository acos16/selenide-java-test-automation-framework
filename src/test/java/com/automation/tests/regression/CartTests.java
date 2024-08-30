package com.automation.tests.regression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.automation.base.BaseTest;
import com.automation.pages.InventoryPage;
import com.automation.utils.PageWaiter;
import com.automation.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

/** Test class that contains tests for the inventory page functionality. */
class CartTests implements BaseTest {

  private final InventoryPage inventoryPage = new InventoryPage();

  @Test
  @DisabledIf("isNotDevEnv")
  void verifyItemCanBeAddedToCart() {
    inventoryPage.loadPage(inventoryPage.getPageUrl());
    PageWaiter.getWaiter().waitForDocumentCompleteState();

    var addToCartButtons = inventoryPage.getAddToCartButton();
    PageWaiter.getWaiter().waitForAngularRequestsToFinish();

    if (addToCartButtons.size() == 0) throw new AssertionError("No items available");
    addToCartButtons.get(Utils.getRandomNumber(addToCartButtons.size())).click();

    assertEquals(
        "1",
        inventoryPage.getItemsInShoppingCart(),
        "Number of items in shopping cart does not match");
  }
}
