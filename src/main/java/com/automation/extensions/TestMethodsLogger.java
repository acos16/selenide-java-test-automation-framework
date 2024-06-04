package com.automation.extensions;

import com.automation.utils.ExtensionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class TestMethodsLogger implements BeforeEachCallback, AfterEachCallback {
    private static final Logger log = LogManager.getLogger(TestMethodsLogger.class);


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Class<?> testClass = ExtensionUtil.getTestClass(context);
        Method testMethod = ExtensionUtil.getTestMethod(context);

        if (testClass == null || testMethod == null) {
            return;
        }

        log.info("Test '{}' - starting...\n", testMethod.getName());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Class<?> testClass = ExtensionUtil.getTestClass(context);
        Method testMethod = ExtensionUtil.getTestMethod(context);

        if (testClass == null || testMethod == null) {
            return;
        }

        log.info("Test '{}' - finished\n", testMethod.getName());
    }
}