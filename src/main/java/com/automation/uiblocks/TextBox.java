package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

/** Represents the TextBox UI block on the Elements page. Applicable only to QA Environment! */
public class TextBox {

  private final SelenideElement fullNameInput = $("#userName");
  private final SelenideElement emailInput = $("#userEmail");
  private final SelenideElement currentAddressInput = $("#currentAddress");
  private final SelenideElement permanentAddressInput = $("#permanentAddress");
  private final SelenideElement submitButton = $("#submit");

  public void setFullName(String name) {
    fullNameInput.setValue(name);
  }

  public void setEmail(String email) {
    emailInput.setValue(email);
  }

  public void setCurrentAddress(String address) {
    currentAddressInput.setValue(address);
  }

  public void setPermanentAddress(String address) {
    permanentAddressInput.setValue(address);
  }

  public void submit() {
    submitButton.click();
  }
}
