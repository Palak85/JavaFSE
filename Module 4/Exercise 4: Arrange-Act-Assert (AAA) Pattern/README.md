# Module 4: Exercise 4 - Arrange-Act-Assert (AAA) Pattern, Setup and Teardown

This project demonstrates how to organize unit tests using the standard **Arrange-Act-Assert (AAA)** pattern and handle fixture lifecycle events using JUnit `@Before` (Setup) and `@After` (Teardown) annotations.

---

### Key Concepts

#### 1. The Arrange-Act-Assert (AAA) Pattern
The AAA pattern is a widely accepted standard for writing readable and clean unit tests. It divides a test method into three distinct sections:
*   **Arrange:** Prepare the environment, instantiate target objects, configure mock behaviors, and initialize input values.
*   **Act:** Execute the target method or logic under test.
*   **Assert:** Verify that the results/actions match the expected outcome.

#### 2. Test Fixtures: Setup & Teardown
To prevent redundant initialization code across different test cases, JUnit provides lifecycles:
*   **Setup (`@Before` in JUnit 4 / `@BeforeEach` in JUnit 5):** Automatically executed before *each* test method starts. Used to initialize common mock lists or database connections.
*   **Teardown (`@After` in JUnit 4 / `@AfterEach` in JUnit 5):** Automatically executed after *each* test method completes. Used to clean up memory, clear references, or disconnect DB sessions.

---

### Project Structure

```text
├── pom.xml
└── src
    └── test
        └── java
            └── com
                └── example
                    └── ListManagerTest.java
```

---

### Implementation Code

#### 1. Test Class (`ListManagerTest.java`)
[ListManagerTest.java](file:///Users/palaksingh/Desktop/fse/Module%204/Exercise%204:%20Arrange-Act-Assert%20%28AAA%29%20Pattern/src/test/java/com/example/ListManagerTest.java)
```java
package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<String> list;

    // Setup method executed before each test using @Before
    @Before
    public void setUp() {
        // Arrange: Prepare common test fixture state
        list = new ArrayList<>();
        list.add("Item1");
        list.add("Item2");
        System.out.println("Setup: List initialized with initial items.");
    }

    // Teardown method executed after each test using @After
    @After
    public void tearDown() {
        list.clear();
        list = null;
        System.out.println("Teardown: List reference cleared.");
    }

    // Test case using Arrange-Act-Assert (AAA) pattern
    @Test
    public void testAddItem() {
        // Arrange
        String newItem = "Item3";

        // Act
        list.add(newItem);

        // Assert
        assertEquals(3, list.size());
        assertTrue(list.contains("Item3"));
    }

    // Test case using Arrange-Act-Assert (AAA) pattern
    @Test
    public void testRemoveItem() {
        // Arrange
        String itemToRemove = "Item1";

        // Act
        list.remove(itemToRemove);

        // Assert
        assertEquals(1, list.size());
        assertFalse(list.contains("Item1"));
    }
}
```

---

### How to Run the Tests

Open your terminal, navigate to the `Module 4/Exercise 4: Arrange-Act-Assert (AAA) Pattern` folder, and run:
```bash
mvn test
```

**Execution Logs Output:**
```text
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< com.example:junit-aaa-demo >---------------------
[INFO] Building junit-aaa-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] Running com.example.ListManagerTest
Setup: List initialized with initial items.
Teardown: List reference cleared.
Setup: List initialized with initial items.
Teardown: List reference cleared.
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.027 s -- in com.example.ListManagerTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
Notice that the setup and teardown trace prints twice (once for each test case), verifying the fixture lifecycle works as expected.
