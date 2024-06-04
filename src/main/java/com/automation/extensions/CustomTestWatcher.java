package com.automation.extensions;

import com.automation.utils.ExtensionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.reflect.Method;
import java.util.Optional;

public class CustomTestWatcher implements TestWatcher {
    private static final Logger log = LogManager.getLogger(CustomTestWatcher.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        Class<?> testClass = ExtensionUtil.getTestClass(context);
        Method testMethod = ExtensionUtil.getTestMethod(context);

        if (testClass == null || testMethod == null) {
            return;
        }

        log.info("Test '{}' - PASSED\n", testMethod.getName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Class<?> testClass = ExtensionUtil.getTestClass(context);
        Method testMethod = ExtensionUtil.getTestMethod(context);

        if (testClass == null || testMethod == null) {
            return;
        }


        log.info("Test '{}' - FAILED\nReason: '{}'\n", testMethod.getName(), cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Class<?> testClass = ExtensionUtil.getTestClass(context);
        Method testMethod = ExtensionUtil.getTestMethod(context);

        if (testClass == null || testMethod == null) {
            return;
        }

        log.info("Test '{}' - DISABLED\nReason: '{}'\n", testMethod,
                reason.isPresent() ? reason.get() : "Unknown reason");
    }
}
