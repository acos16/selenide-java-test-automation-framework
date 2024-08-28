package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;

public class ProductItem {
  public void addProductToCart(String productName) {
    $(String.format("[data-test='add-to-cart-%s']", productName)).click();
  }

  public void removeProductFromCart(String productName) {
    $(String.format("[data-test='remove-%s']", productName)).click();
  }
}
