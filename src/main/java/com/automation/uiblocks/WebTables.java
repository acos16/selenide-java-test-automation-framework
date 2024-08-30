package com.automation.uiblocks;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/** Represents the WebTables UI block on the Elements page. Applicable only to QA environment! */
public class WebTables {

  private final ElementsCollection rows = $$(".rt-tr-group");
  private final SelenideElement addButton = $("#addNewRecordButton");

  public ElementsCollection getRows() {
    return rows;
  }

  public void addNewRecord() {
    addButton.click();
  }
}
