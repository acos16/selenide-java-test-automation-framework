# Test Automation Framework

## Table of Contents

- [Overview](#overview)
- [Folder Structure](#folder-structure)
- [Package Descriptions](#package-descriptions)
- [Implementation Details](#implementation-details)
    - [Resources](#resources)
    - [Main Components](#main-components)
- [Test Organization](#test-organization)
    - [Test Suites](#suites)
- [Running the Tests](#running-the-tests)
- [CI Pipeline](#ci-pipeline)

## Overview

This framework is designed for UI test automation and contains some basic setups. It can be further extended and
enhanced to accommodate more complex capabilities that would be required for testing a web application.

### Folder Structure

A well-organized folder structure for a test automation framework can significantly enhance maintainability and
scalability. Here’s a recommended structure, along with suggestions for naming conventions:

* `config`
* `base`
* `pages`
* `utils`
* `extensions`
* `exceptions`
* `uiblocks`
* `entity`
* `tests`
* `suites`

### Package Descriptions

#### `config`

* Contains classes for configuration management, including loading properties and setting up environment configurations.

#### `base`

* Includes base or abstract classes that other page classes can extend. Common functionalities and utilities shared
  across multiple page objects are placed here. Alternatively, this package can be named `common`.

#### `pages`

* Contains Page Object classes that represent different pages of the application under test, following the Page Object
  Model (POM) design pattern.

#### `utils`

* Contains utility classes and helper methods that can be used across the framework. This promotes code reuse and
  simplifies test class implementations.

#### `exceptions`

* Contains custom exception classes to handle specific errors within the framework.

#### `uiblocks`

* Implements complex web elements.

#### `entity`

* Defines entities used within the framework.

#### `extensions`

* Defines additional capabilities and extensions to be used across the framework.

#### `tests`

* Contains the test cases. It is good practice to separate test logic from test scenarios.

#### `suites`

* Defines test suite collections to organize and manage tests.

### Implementation Details

#### Resources

* `config.json`: Contains the URLs for the environment and for the pages, which can be relative to the base URL
  specified in `urls` and the Users of the application

#### Main Components

* **Core Implementation**: Manages data (e.g., resource loader) and facilitates interaction with the application under
  test (e.g., configuration, pages, helpers, web components like tables and sidebars).
* **Pages**: Extend the `BasePage` class, each page will load based on a given url that is specified in `config.json`.
  Each page includes an `isDisplayed` method to verify correct loading, which can be implemented in various ways such as
  checking a unique element, the page title, the current URL, or the page load status using JavaScript:

```java
public boolean isDisplayed(){
        return executeJavaScript("return document.readyState").equals("complete");
        }
```

or

```java
public boolean isDisplayed(){
        return executeJavaScript("return performance.getEntriesByType('resource').length > 0;");
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
3. Run tests: this step runs the tests using the Gradle `customTest` task.
4. Upload test results: this step uploads the test reports as an artifact.