package com.automation.base;

import com.automation.config.EnvironmentLoader;
import com.automation.extensions.CustomTestWatcher;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This interface represents the base test configuration, It uses Junit5 {@link ExtendWith}
 * annotation to register custom functionality provided by {@link CustomTestWatcher}
 *
 * <p>This interface should be extended by each test class. It can further be ehanced with common
 * methods for tests.
 */
@ExtendWith({CustomTestWatcher.class})
@ExtendWith({ScreenShooterExtension.class})
public interface BaseTest {

  default boolean isNotQaEnv() {
    return !EnvironmentLoader.readEnvironmentFromProperties().equalsIgnoreCase("qa");
  }

  default boolean isNotDevEnv() {
    return !EnvironmentLoader.readEnvironmentFromProperties().equalsIgnoreCase("dev");
  }
}
