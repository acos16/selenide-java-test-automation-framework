## Framework description

A well-organized folder structure for a test automation framework can significantly enhance maintainability and
scalability. Here’s a recommended structure, along with suggestions for naming conventions:
src/main config base pages utils extensions exceptions uiblocks entity src/test suites

### Package name explanation

Package Naming Conventions

* config: Contains classes related to configuration, such as loading properties, setting up environment configurations,
  etc.
* base: Contains base or abstract classes that other page classes can extend.Common functionality and utilities to be
  shared across multiple page objects, should be placed in here (alternative packages can be named 'common')
* pages: Contains Page Object classes representing different pages of the application under test.
* utils: Contains utility classes and helper methods that can be used across the framework. Keep reusable utility
  methods in the utils package. This promotes code reuse and simplifies test class implementations.
* exceptions: Custom exception classes to handle specific errors within the framework.
* uiblocks: Contains implementation of complex web elements
* entity: Contains the entities from the framework
* extensions: It defines additional capabilities to be used across the framework
* tests: contains the tests. It is good practice to separate the test logic from the tests scenarios
* suites: Contains test suite definitions

**Notes:**

Page Object Model (POM): Implement the Page Object Model (POM) design pattern by creating page classes in the pages
package. Each page class should encapsulate the behavior and elements of a specific page

### Implementation explanations

Resources

* config.json contains the URLs for pages. These can also be relative to the base URL specified in urls

Main

* Contains **core** implementation to manage data (i. e.: resources loader) and to be able to work with the application
  under test (configuration, pages, helpers, web components: tables, sidebars,etc.).
* The pages extend base page: each page will load based on a given url that is specified in the config.json file. Pages
  will also contain a 'isDisplayed' method which checks if the page is correctly loaded. This can be an element from the
  page. There are other possible implementations for 'isdisplayed' method. In this example I am checking an item in the
  page (a unique identifier specified to that page only). Other ways to do it: check page title, check page current url.
  Or check page load status. This can be achieved using JavaScript:

```
public boolean isDisplayed() {
return executeJavaScript("return document.readyState").equals("complete");
}
```

Or

```
public boolean isDisplayed() {
return executeJavaScript("return performance.getEntriesByType('resource').length > 0;");
}
```

* CustomTestWatcher: Test watcher: a way for processing tests and test results. CustomTestWatcher: Implements the
  TestWatcher interface. Logs different events such as test start, success, failure, abort, and disable.

Test

Organizing the tests in suites

* The suites package is used to group and organize tests into collections called test suites and gain better control and
  flexibility over your test execution process, making it easier to manage large sets of tests.
* With Test suites you can:
    * define how and which tests should be run together, various criteria such as functional areas, regression tests,
      smoke tests, etc.
    * manage test execution of specific tests based on the requirement (e.g. smoke, etc)
    * apply different configurations for different suites (e.g., different environments or browsers).
    * parallel Execution: Configure test suites to run tests in parallel to reduce execution time.

In this sample project I organized the tests in 2 categories: smoke and regression. I’ve put the tests into separate
packages, such as smoke for smoke tests and regression for regression tests. I used JUnit 5’s @SelectPackages annotation
to include all tests from those specific packages in your test suites. Ensure that smoke or regression tests are placed
in the right packages.

Other possibilities exist too: grouping them based on functionality is also a good way to go.

## Running the tests

To run with a different environment, you can update the gradle.properties file before running the tests

```
environment = qa
```

use following Gradle command:

```
./gradlew test -Denvironment=qa
```

To run different test suites, you can

```
./gradlew test -PsuiteType=smoke
```
