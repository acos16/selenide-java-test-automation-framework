# Test Automation Framework

## Table of Contents

- [Overview](#overview)
- [Folder Structure and Package Descriptions](#folder-structure-and-package-descriptions)
- [Implementation Details](#implementation-details)
  - [Resources](#resources)
  - [Main Components](#main-components)
- [Test Organization](#test-organization)
  - [Test Suites](#test-suites)
- [Running the Tests](#running-the-tests)
- [CI Pipeline](#ci-pipeline)
- [Code Quality](#code-quality)
- [Design Decisions](#design-decisions)

## Overview

This framework is designed for UI test automation and includes basic setups that can be extended and enhanced to accommodate more complex requirements for testing web applications. It follows the Page Object Model (POM) pattern, integrates static code analysis, and enforces code formatting.

## Folder Structure and Package Descriptions

A well-organized folder structure is crucial for maintaining and scaling the test automation framework. Below is the recommended structure along with descriptions of each package:

- **`config/`**: Contains classes for configuration management, including loading properties and setting up environment configurations. This ensures a consistent configuration across the framework.

- **`base/`**: Includes base or abstract classes that other page classes can extend. Common functionalities and utilities shared across multiple page objects are placed here, promoting code reuse and a single point of maintenance for shared features. This package may also be referred to as `common`.

- **`pages/`**: Contains Page Object classes that represent different pages of the application under test, following the Page Object Model (POM) design pattern. POM helps in reducing code duplication and improving test maintenance.

- **`utils/`**: Contains utility classes and helper methods that can be used across the framework. This promotes code reuse and simplifies test class implementations, handling tasks like data processing, formatting, or specialized functions.

- **`extensions/`**: Defines additional capabilities and framework extensions that can be utilized across the project. This package could include custom test listeners, advanced logging, or other reusable extensions that enhance the core functionality.

- **`exceptions/`**: Contains custom exception classes to handle specific errors within the framework, providing more granular error handling and improving the debugging process.

- **`uiblocks/`**: Implements complex web elements into reusable components, allowing for cleaner and more maintainable page objects by encapsulating repeated UI interactions.

- **`entity/`**: Defines the data entities used within the framework, often mirroring the structure of data objects in the application under test. This helps in managing test data more effectively and consistently.

- **`tests/`**: Contains the tests, separated from the logic that drives them. Keeping test scenarios distinct from implementation logic helps in maintaining a clear structure and improves the maintainability of the tests.

- **`suites/`**: Defines collections of test suites to organize and manage tests effectively. This organization allows better control over test execution, facilitating targeted test runs like smoke tests or full regression tests, and enabling parallel execution.

## Implementation Details

### Resources

- **`config.json`**: A central configuration file containing environment URLs and page-specific URLs, which can be relative to the base URL. It also includes user credentials and other environment-specific settings. 

### Main Components

- **Core Implementation**: Manages data loading (e.g., resource loader) and facilitates interaction with the application under test (e.g., configuration, pages, helpers, web components like tables and sidebars).

- **Pages**: Extend the `BasePage` class. Each page loads based on a URL specified in `config.json`. Pages include an `isDisplayed` method to verify that they are loaded correctly, either by checking unique elements, the page title, the current URL, or using JavaScript to confirm the page load status.

```java
  public boolean isDisplayed() {
      return executeJavaScript("return document.readyState").equals("complete");
  }
```

* **CustomTestWatcher**: Implements the `TestWatcher` interface to log different test events such as start, success,
  failure, abort, and disable.

### Test Organization

##### Suites

The `suites` package groups and organizes tests into collections called test suites, offering better control and
flexibility over test execution. Benefits include:

* Defining how and which tests should run together based on various criteria (e.g., functional areas, regression tests,
  smoke tests).
* Managing test execution based on requirements (e.g., smoke tests).
* Applying different configurations for different suites (e.g., different environments or browsers).
* Configuring parallel execution to reduce execution time.

In this project, tests are organized into two categories: `smoke` and `regression`. Tests are placed in respective
packages, and JUnit 5's `@SelectPackages` annotation is used to include all tests from these packages in the test
suites. It is also a good practice to group the tests based on functionality.

## Running the Tests

#### Environment

* To run tests with a different **environment**, update the `gradle.properties` file:

```
environment = qa
```

or use the following Gradle command:

  ```
  ./gradlew test -Denvironment=qa
  ```

#### Test suites

* To run different test suites:

```
./gradlew customTest -PsuiteType=smoke
```

#### Browser

* To run test suites on a different browser:

```
./gradlew customTest -Dbrowser=firefox
```

## CI Pipeline

The tests are automatically triggered by the GitHub Actions workflow on every push or pull request to `main` branch. You
can also trigger the workflow manually from the GitHub Actions tab.

The CI Pipeline ensures that tests are executed consistently with each build.

### Steps:

1. Checkout code: this step checks out the repository code so that it can be accessed by subsequent steps.
2. Setup JDK: this step sets up Java Development Kit (JDK) which is required to run the tests.
3. Spotless Check: this steps check code format.
4. PMD: this steps does a static analysis of the code and provides a report.
5. Run tests: this step runs the tests using the Gradle `customTest` task.
6. Upload reports and test results: this step uploads artifacts.

[dorny test reporter](https://github.com/dorny/test-reporter) is used to display the test results. Please notice that there are some GitHub  
[limitations](https://github.com/dorny/test-reporter?tab=readme-ov-file#github-limitations), among which I will mention:
* manually triggering the build will not display the test results
* for scheduled builds the test results will not be displayed
* it is not possible to specify which test report should belong to which workflow

## Code Quality

### Spotless

Spotless is integrated into the framework to enforce code formatting standards. It automatically formats the code according to the defined rules, helping maintain consistent code style throughout the project.

To apply Spotless formatting:
```groovy
./gradlew spotlessApply
```
To check the formatting without applying changes:

```groovy
./gradlew spotlessCheck
```


### PMD

PMD is used for static code analysis to detect potential bugs, dead code, suboptimal code, and other issues. It runs automatically as part of the build process and helps ensure that the code adheres to best practices.

To run PMD:
```groovy
./gradlew pmdMain
```

## Design Decisions

### Test Suites

Running different test suites allows for targeted testing, such as running only smoke tests for quick validation or full regression tests for thorough coverage. This approach optimizes test execution based on the stage of development or deployment.

### Browser and Environment Configuration

Placing the browser and environment configuration in BasePage rather than BaseTest provides more flexibility in configuring these settings on a per-page basis. This is useful when different pages require different setups or when testing complex applications with varying requirements across pages.

BasePage 
- is better suited for managing interactions, configurations, and behavior specific to web pages or components within the application under test.
- should contain functionalities related to browser configuration, page interactions, page validations, navigation, and resource management.

BaseTest 
- is better suited for handling configurations, test lifecycle management, and shared test enhancements that apply across all test classes in your framework.
- is ideal for test-related configurations that need to be applied universally across all test classes.


### Config File
Having a single config.json file ensures
all configurations are centralized in a single config.json file to simplify management and reduce redundancy. 
This approach makes it easier to maintain and update configurations, as all settings are in one place.
Since dev, qa and prod environment all mirror each other,
there is no need to provide separate configuration files for each specific environment. 
If that is not the case, then a better approach would be to have a configuration file for each environment: `dev.json`, `test.json`, `prod.json`, each containing base_url, pages URLs and users' credentials.

### Manual Workflow Trigger

Allowing manual triggers for the CI workflow provides flexibility for developers to run tests on-demand, without waiting for a code change. This is particularly useful for running tests in specific environments or under specific conditions.

### Running on Different Environments and Browsers

Running tests across different environments and browsers ensures broader test coverage and helps identify issues that may only occur under specific conditions. This practice increases confidence in the application’s compatibility and reliability.