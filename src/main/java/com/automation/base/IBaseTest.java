package com.automation.base;

import com.automation.extensions.CustomTestWatcher;
import com.automation.extensions.TestMethodsLogger;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({CustomTestWatcher.class, TestMethodsLogger.class})
public interface IBaseTest {


}
