package com.automation.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.automation.base.BasePage;
import com.automation.config.PagesLoader;
import com.automation.uiblocks.CheckBox;
import com.automation.uiblocks.RadioButton;
import com.automation.uiblocks.TextBox;
import com.automation.uiblocks.WebTables;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * The ElementsPage class represents the elements page of the application. It extends the {@link
 * BasePage} class and provides methods to interact with the elements page elements.
 *
 * <p>Applicable only to QA environment!
 */
public class ElementsPage extends BasePage {

  private final SelenideElement title = $("title");
  private final ElementsCollection menuItems = $$(".element-group");

  private final TextBox textBox = new TextBox();
  private final CheckBox checkBox = new CheckBox();
  private final RadioButton radioButton = new RadioButton();
  private final WebTables webTables = new WebTables();

  /**
   * Gets the page's title
   *
   * @return page title
   */
  public String getPageTitle() {
    return title.getText();
  }

  /**
   * Returns the URL of the elements page.
   *
   * @return the URL of the elements page.
   */
  @Override
  public String getPageUrl() {
    return PagesLoader.loadPage().get("elements");
  }

  /**
   * Checks if the elements page is displayed by verifying the presence of the main title element.
   *
   * @return true if the elements page is displayed, false otherwise.
   */
  @Override
  public boolean isDisplayed() {
    return this.getPageUrl().contains("elements");
  }

  @Override
  public boolean isLoggedIn() {
    // requires no login
    return true;
  }

  /**
   * Selects the Elements Panel from the menu items
   *
   * @return the elements components
   */
  public void selectElementsPanel() {
    $(byText("Elements")).click();
  }

  /**
   * Gets the TextBox UI block.
   *
   * @return the TextBox UI block.
   */
  public TextBox getTextBox() {
    return textBox;
  }

  /**
   * Gets the CheckBox UI block.
   *
   * @return the CheckBox UI block.
   */
  public CheckBox getCheckBox() {
    return checkBox;
  }

  /**
   * Gets the RadioButton UI block.
   *
   * @return the RadioButton UI block.
   */
  public RadioButton getRadioButton() {
    return radioButton;
  }

  /**
   * Gets the WebTables UI block.
   *
   * @return the WebTables UI block.
   */
  public WebTables getWebTables() {
    return webTables;
  }
}
