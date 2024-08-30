package com.automation.tests.regression;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.automation.base.BaseTest;
import com.automation.pages.ElementsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

class ElementsRadioButtonTests implements BaseTest {

  @Test
  @DisabledIf("isNotQaEnv")
  void testRadioButtonFunctionality() {
    ElementsPage elementsPage = new ElementsPage();
    elementsPage.loadPage(elementsPage.getPageUrl());

    elementsPage.getRadioButton().selectRadioButtonPanel();

    elementsPage.getRadioButton().selectImpressive();
    assertTrue(
        elementsPage.getRadioButton().isImpressiveSelected(),
        "Impressive radio button should be selected");
  }
}
