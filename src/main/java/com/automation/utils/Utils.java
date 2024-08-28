package com.automation.utils;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * The Utils class provides utility methods to be used in the test automation framework.
 * This is a utility class and should not be instantiated.
 */
public class Utils {
    private static final String COMPLEX_STRING = "Test#!@ABC123";

    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * @throws UnsupportedOperationException if an attempt is made to instantiate this class.
     */
    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Returns a predefined complex password string.
     *
     * @return a complex password string.
     */
    public static String getComplexPassword() {
        return COMPLEX_STRING;
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param range the upper bound (exclusive) for the random number.
     * @return a random integer between 0 (inclusive) and the specified range (exclusive).
     */
    public static Integer getRandomNumber(int range) {
        Random random = new Random();
        int randomIndex = random.nextInt(range);
        return randomIndex;
    }

    /**
     * Genearates a random string
     * @param length
     * @return a random string with the specified length.
     */
    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * Generates a random email
     * @return a random email with 10 characters
     */
    public static String getRandomEmail() {
        return getRandomString(10) + "@example.com";
    }
}
