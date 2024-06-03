## Test framework structure

A well-organized folder structure for a test automation framework can significantly enhance maintainability and
scalability. Here’s a recommended structure, along with suggestions for naming conventions:

src/main

* config
* base
* pages
* utils
* exceptions

src/test

* suites

Package Naming Conventions

* config: Contains classes related to configuration, such as loading properties, setting up environment configurations,
  etc.
* base: Contains base or abstract classes that other page classes can extend.Common functionality and utilities to be
  shared across multiple page objects, should be placed in here (alternative packages can be named 'common')
* pages: Contains Page Object classes representing different pages of the application under test.
* utils: Contains utility classes and helper methods that can be used across the framework.
* exceptions: Custom exception classes to handle specific errors within the framework.
* suites: Contains test suite definitions,

The suites package in a test automation framework is used to group and organize tests into collections called test
suites. Test suites can define how and which tests should be run together, allowing for different configurations and
test groupings based on various criteria such as functional areas, regression tests, smoke tests, etc.

Purpose of the suites Package

	1.	Organization: Group related tests into suites to manage test execution efficiently.
	2.	Configuration: Define specific configurations and setups for different test runs.
	3.	Execution Control: Control the order and combination of test executions.

Benefits of Using Suites

	1.	Selective Execution: Run only specific sets of tests based on the requirement (e.g., smoke tests after a deployment).
	2.	Parallel Execution: Configure test suites to run tests in parallel to reduce execution time.
	3.	Configuration Management: Apply different configurations for different suites (e.g., different environments or browsers).

By organizing your tests into suites, you gain better control and flexibility over your test execution process, making
it easier to manage large sets of tests.

If you organize your tests by placing them into separate packages, such as smoke for smoke tests and regression for
regression tests, you can leverage JUnit 5’s @SelectPackages annotation to include all tests from those specific
packages in your test suites. This approach simplifies the suite definitions since you only need to reference the
package names.

#### Notes:

Page Object Model (POM): Implement the Page Object Model (POM)
design pattern by creating page classes in the pages package. Each page class should encapsulate the behavior and
elements of a specific page.

Utility Classes: Keep reusable utility methods in the utils package. This promotes code reuse and simplifies test class
implementations.

Test Data: Organize test data and data providers in the data package to separate test logic from test data.