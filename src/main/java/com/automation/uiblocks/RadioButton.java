package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;

import com.automation.utils.PageWaiter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

/** Represents the RadioButton UI block on the Elements page. Applicable only to QA environment! */
public class RadioButton {

  private final SelenideElement radioButtonPanel = $("#item-2");
  private final SelenideElement yesRadio = $("#yesRadio");
  private final SelenideElement impressiveRadio = $("#impressiveRadio");

  public void selectRadioButtonPanel() {
    radioButtonPanel.click();
    PageWaiter.getWaiter().waitForAngularRequestsToFinish();
  }

  public void selectYes() {
    yesRadio.parent().click();
  }

  public void selectImpressive() {
    PageWaiter.getWaiter().waitForAngularRequestsToFinish().waitForDocumentCompleteState();
    impressiveRadio.parent().scrollIntoView(true);
    impressiveRadio.parent().shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
  }

  public boolean isYesSelected() {
    return yesRadio.isSelected();
  }

  public boolean isImpressiveSelected() {
    return impressiveRadio.isSelected();
  }
}
