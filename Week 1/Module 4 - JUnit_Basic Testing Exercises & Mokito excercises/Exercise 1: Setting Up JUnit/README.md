# Setting Up JUnit (Module 4 Exercise 1)

This project demonstrates the setup of **JUnit 4** in a Maven-based Java project to write and run unit tests.

## Directory Structure
- **pom.xml**: Maven configuration declaring the project details and the JUnit dependency.
- **src/main/java/com/example/Calculator.java**: A simple helper class containing arithmetic operations.
- **src/test/java/com/example/CalculatorTest.java**: Unit test suite using JUnit 4 `@Test`, `@Before` annotations, and assertions.
- **README.md**: Documentation on configuration and usage.

---

## 1. Maven Dependency Setup (`pom.xml`)
To integrate JUnit 4.13.2, the following XML block is defined in the `<dependencies>` section of the `pom.xml`:

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

---

## 2. Test Execution
When imported into a standard Java IDE (such as IntelliJ IDEA, Eclipse, or VS Code), the IDE will automatically resolve the Maven dependencies and compile the classes.

- **To run in an IDE**:
  - Right-click the `CalculatorTest` class file.
  - Select **Run 'CalculatorTest'** or **Run Tests**.
- **To run via Maven CLI**:
  ```bash
  mvn test
  ```
