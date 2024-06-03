## Automation framework with Selenide and Java

In this repository you will learn:

* what is Selenide
* setting up (development) environment
* basic structure of a test automation framework
* how to perform UI testing with Selenide
* UI locators
* gradle

Viewing tutorials and watching videos on test automation can be a way to start, but practice makes perfect and often
what is lacking is a concrete example on how to put everything together.

This sample project uses:

* java
* gradle
* selenide
* junit

Since you've landed on GitHub I will start from the premise that some (basic) knowledge about version control systems
and the automation ecosystem are known.

To run with a different environment, you can

1. update the gradle.properties file before running the tests

```
environment = qa
```

2. use following Gradle command:

```
./gradlew test -Denvironment=qa
```

To run different test suites, you can

```
./gradlew test -PsuiteType=smoke
```