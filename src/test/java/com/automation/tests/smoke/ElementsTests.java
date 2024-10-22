package com.automation.tests.smoke;

import static org.junit.jupiter.api.Assertions.*;

import com.automation.base.BaseTest;
import com.automation.pages.ElementsPage;
import com.automation.utils.PageSyncHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

class ElementsTests implements BaseTest {

  @Test
  @DisabledIf("isNotQaEnv")
  void testElementsPageIsDisplayed() {

    ElementsPage elementsPage = new ElementsPage();
    elementsPage.loadPage(elementsPage.getPageUrl());
    PageSyncHelper.create().waitForDocumentReady();

    assertTrue(elementsPage.isDisplayed(), "Elements page should be displayed");
  }
}
