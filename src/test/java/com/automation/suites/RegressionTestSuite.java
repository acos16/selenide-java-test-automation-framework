package com.automation.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * The RegressionTestSuite class is used to define a test suite for regression tests.
 * <p>
 * This class uses the {@link Suite} and {@link SelectPackages} annotations to specify that it is a test suite
 * and to select the package containing the regression tests.
 * </p>
 * <p>
 * The class itself remains empty and serves only as a holder for the annotations.
 * </p>
 */
@Suite
@SelectPackages("com.automation.tests.regression")
public class RegressionTestSuite {
    //This class remains empty, it is used only as a holder for the above annotation
}
