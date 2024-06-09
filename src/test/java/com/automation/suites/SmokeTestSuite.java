package com.automation.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * The SmokeTestSuite class is used to define a test suite for smoke tests.
 * <p>
 * This class uses the {@link Suite} and {@link SelectPackages} annotations to specify that it is a test suite
 * and to select the package containing the smoke tests.
 * </p>
 * <p>
 * The class itself remains empty and serves only as a holder for the annotations.
 * </p>
 */
@Suite
@SelectPackages("com.automation.tests.smoke")
public class SmokeTestSuite {
    //This class remains empty, it is used only as a holder for the above annotation
}
