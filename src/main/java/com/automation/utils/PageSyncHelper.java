package com.automation.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class PageSyncHelper {

  public static final Logger log = LogManager.getLogger(PageSyncHelper.class);

  private PageSyncHelper() {}

  public static PageSyncHelper create() {
    return new PageSyncHelper();
  }

  public PageSyncHelper waitForAngularToComplete() {
    try {
      Selenide.Wait()
          .withTimeout(Duration.ofMinutes(1))
          .until(
              driver -> {
                try {
                  return Boolean.valueOf(
                      Selenide.executeJavaScript(
                              "return (function(){return (window.getAllAngularTestabilities()."
                                  + "findIndex(x=>!x.isStable()) === -1).toString()})()")
                          .toString());
                } catch (final WebDriverException e) {
                  log.debug("Web driver exception occurred: {}", e.getMessage());
                  return this;
                }
              });
    } catch (final TimeoutException e) {
      log.warn("Angular requests wasn't completed", e);
    } catch (final WebDriverException e) {
      log.debug("Exception while waiting for angular request to be completed: {}", e.getMessage());
    }
    return this;
  }

  public PageSyncHelper waitForDocumentReady() {
    try {
      Selenide.Wait()
          .withTimeout(Duration.ofSeconds(30))
          .until(
              (final WebDriver driver) -> {
                final String documentState =
                    (String)
                        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                            .executeScript("return document.readyState");
                log.debug(String.format("Current document state is: %s", documentState));
                return "complete".equals(documentState);
              });
    } catch (final TimeoutException e) {
      log.info("Can't wait till document.readyState is complete", e);
    }
    return this;
  }
}
