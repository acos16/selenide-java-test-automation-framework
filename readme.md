### Test automation framework with Java and Selenide

Viewing tutorials and watching videos on test automation can be a way to start, but practice makes perfect and often
what is lacking is a concrete example on how to put everything together (or focusing on too few or too simple examples).

A test automation framework is nothing more than a set of guidelines or rules used for creating and designing test
cases. It consists of a combination of practices and tools or libraries that are designed to help QA engineers creating
test scripts.

These guidelines can include coding standards and conventions, how to handle test-data how to organize test logic and
test ma, how to process the test results, or how to access various resources.

Technologies used in this repository:

* Java
* Selenide
* Gradle
* Junit5
* Log4j
* Jackson

Since you've landed on GitHub I will start from the premise that some (basic)
knowledge about programming, version control systems and the automation ecosystem
(build management tools, tools for UI testing, locators, CI/CD just to name the most important ones) are known.

Details about the framework can be found [here](src/main/java/com/automation/doc/decription.md).

Capabilities the framework offers:

* Run on different instances : dev environment, etc
* Run on different browsers
* Run different groups of tests (test suites) using gradle tasks