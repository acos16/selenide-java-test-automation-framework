package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

/** Represents the CheckBox UI block on the Elements page. Applicable only to QA environment! */
public class CheckBox {

  private final SelenideElement expandAllButton = $(".rct-option-expand-all");
  private final SelenideElement collapseAllButton = $(".rct-option-collapse-all");

  public void expandAll() {
    expandAllButton.click();
  }

  public void collapseAll() {
    collapseAllButton.click();
  }

  public void selectCheckbox(String label) {
    $(String.format("label[for='%s']", label)).click();
  }
}
