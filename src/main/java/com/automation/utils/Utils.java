package com.automation.utils;

import java.util.Random;

public class Utils {
    private static final String COMPLEX_STRING = "Test#!@ABC123";

    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getComplexPassword() {
        return COMPLEX_STRING;
    }

    public static Integer getRandomNumber(int range) {
        Random random = new Random();
        int randomIndex = random.nextInt(range);
        return randomIndex;
    }

}
