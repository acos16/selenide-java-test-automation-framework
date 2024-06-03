package com.automation.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.automation.tests.regression")
public class RegressionTestSuite {
    //This class remains empty, it is used only as a holder for the above annotation
}
