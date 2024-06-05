package com.automation.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.reflect.Method;
import java.util.Optional;


public class CustomTestWatcher implements TestWatcher, BeforeTestExecutionCallback {
    private static final Logger log = LogManager.getLogger(CustomTestWatcher.class);

    private String getTestMethodName(ExtensionContext context) {
        return context.getTestMethod().map(Method::getName).orElse("Unknown");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        log.info("Test {} STARTED", getTestMethodName(context));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("Test '{}' - PASSED\n", getTestMethodName(context));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.info("Test '{}' - FAILED\nReason: '{}'\n", getTestMethodName(context), cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.info("Test '{}' - DISABLED\nReason: '{}'\n", getTestMethodName(context),
                reason.orElse("No reason"));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.info(" Test '{}' - ABORTED\nReason: {}", getTestMethodName(context), cause.getMessage());
    }


}
