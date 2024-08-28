package com.automation.base;

import com.automation.extensions.CustomTestWatcher;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This interface represents the base test configuration,
 * It uses Junit5 {@link ExtendWith} annotation to register custom functionality
 * provided by {@link CustomTestWatcher}
 * <p>
 * This interface should be extended by each test class.
 * It can further be ehanced with common methods for tests.
 * </p>
 */
@ExtendWith({CustomTestWatcher.class})
public interface BaseTest {

}
