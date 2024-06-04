package com.automation.utils;

import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

public final class ExtensionUtil {
    private ExtensionUtil() {
        /*
         * Nothing to do
         */
    }

    /**
     * Return the test class out of an {@link ExtensionContext}
     *
     * @param context The {@link ExtensionContext}
     * @return The test class or null if test class not found in the context
     */
    public static Class<?> getTestClass(ExtensionContext context) {
        Optional<Class<?>> optionalClassValue = context.getTestClass();

        Class<?> testClass = null;

        if (optionalClassValue.isPresent()) {
            testClass = optionalClassValue.get();
        }

        return testClass;
    }

    /**
     * Return the test method out of an {@link ExtensionContext}
     *
     * @param context The {@link ExtensionContext}
     * @return The test method or null if the test method not found in the context
     */
    public static Method getTestMethod(ExtensionContext context) {
        Optional<Method> optionalTestMethod = context.getTestMethod();

        Method testMethod = null;

        if (optionalTestMethod.isPresent()) {
            testMethod = optionalTestMethod.get();
        }

        return testMethod;
    }
}
