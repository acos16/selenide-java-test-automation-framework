package com.automation.utils;

public class Utils {
    private static final String COMPLEX_STRING = "Test#!@ABC123";

    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getComplexPassword() {
        return COMPLEX_STRING;
    }
}
