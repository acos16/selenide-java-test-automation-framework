package com.automation.extensions;

import java.lang.reflect.Method;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

/**
 * The CustomTestWatcher class implements JUnit 5's {@link TestWatcher} and {@link
 * BeforeTestExecutionCallback} interfaces to provide custom logging behavior before and after test
 * execution.
 */
public class CustomTestWatcher implements TestWatcher, BeforeTestExecutionCallback {
  private static final Logger log = LogManager.getLogger(CustomTestWatcher.class);

  /**
   * Retrieves the name of the test method from the given {@link ExtensionContext}.
   *
   * @param context the context for the extension, which provides information about the test method.
   * @return the name of the test method, or "Unknown" if the method name is not available.
   */
  private String getTestMethodName(ExtensionContext context) {
    return context.getTestMethod().map(Method::getName).orElse("Unknown");
  }

  /**
   * Logs a message before the test execution starts.
   *
   * @param context the context for the extension, which provides information about the test method.
   */
  @Override
  public void beforeTestExecution(ExtensionContext context) {
    log.info("Test {} STARTED", getTestMethodName(context));
  }

  /**
   * Logs a message when a test is successful.
   *
   * @param context the context for the extension, which provides information about the test method.
   */
  @Override
  public void testSuccessful(ExtensionContext context) {
    log.info("Test '{}' - PASSED\n", getTestMethodName(context));
  }

  /**
   * Logs a message when a test fails.
   *
   * @param context the context for the extension, which provides information about the test method.
   * @param cause the throwable that caused the test to fail.
   */
  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    log.info("Test '{}' - FAILED\nReason: '{}'\n", getTestMethodName(context), cause.getMessage());
  }

  /**
   * Logs a message when a test is disabled.
   *
   * @param context the context for the extension, which provides information about the test method.
   * @param reason an optional reason why the test was disabled.
   */
  @Override
  public void testDisabled(ExtensionContext context, Optional<String> reason) {
    log.info(
        "Test '{}' - DISABLED\nReason: '{}'\n",
        getTestMethodName(context),
        reason.orElse("No reason"));
  }

  /**
   * Logs a message when a test is aborted.
   *
   * @param context the context for the extension, which provides information about the test method.
   * @param cause the throwable that caused the test to be aborted.
   */
  @Override
  public void testAborted(ExtensionContext context, Throwable cause) {
    log.info(" Test '{}' - ABORTED\nReason: {}", getTestMethodName(context), cause.getMessage());
  }
}
