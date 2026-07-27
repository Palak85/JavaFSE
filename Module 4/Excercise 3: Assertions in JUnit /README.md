# Module 4: Exercise 3 - Assertions in JUnit

This project illustrates the usage of various JUnit 5 (Jupiter) assertions to validate and verify expected conditions in Java unit testing.

---

### What are Assertions in JUnit?

Assertions are utility methods inside the `org.junit.jupiter.api.Assertions` class (for JUnit 5) used to verify that the actual values produced by code execution match the expected specifications. If an assertion fails, the test method execution stops immediately and JUnit records a test failure.

#### Core Assertions Used:
*   `assertEquals(expected, actual)`: Asserts that expected and actual values are equal.
*   `assertTrue(condition)`: Asserts that the supplied boolean condition is true.
*   `assertFalse(condition)`: Asserts that the supplied boolean condition is false.
*   `assertNull(actual)`: Asserts that the supplied object reference is null.
*   `assertNotNull(actual)`: Asserts that the supplied object reference is not null.

---

### Project Structure

```text
├── pom.xml
└── src
    └── test
        └── java
            └── com
                └── example
                    └── AssertionsTest.java
```

---

### Implementation Code

#### 1. Test Class (`AssertionsTest.java`)
[AssertionsTest.java](file:///Users/palaksingh/Desktop/fse/Module%204/Excercise%203:%20Assertions%20in%20JUnit%20/src/test/java/com/example/AssertionsTest.java)
```java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest { 

    @Test 
    public void testAssertions() { 
        // Assert equals 
        assertEquals(5, 2 + 3); 
        
        // Assert true 
        assertTrue(5 > 3); 
        
        // Assert false 
        assertFalse(5 < 3); 
        
        // Assert null 
        assertNull(null); 
        
        // Assert not null 
        assertNotNull(new Object()); 
    } 
}
```

---

### How to Run the Tests

Open your terminal, navigate to the `Module 4/Excercise 3: Assertions in JUnit ` folder, and run:
```bash
mvn test
```

**Expected Output:**
```text
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.example:junit-assertions-demo >------------------
[INFO] Building junit-assertions-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] --- maven-surefire-plugin:3.2.2:test (default-test) @ junit-assertions-demo ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AssertionsTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 s -- in com.example.AssertionsTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
