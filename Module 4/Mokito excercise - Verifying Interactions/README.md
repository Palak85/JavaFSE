# Module 4: Mockito - Verifying Interactions

This project illustrates how to test Java code dependencies using **Mockito** to verify that specific interaction methods are called on mock objects.

---

### Key Concepts

#### 1. What is Mockito Verification?
Verification is the act of checking that a mock object was interacted with in a specific way during the execution of a test case. While stubbing (`when().thenReturn()`) tells a mock how to behave, verification (`verify()`) ensures that the code under test actually invoked the expected dependency methods.

#### 2. Key Verification API Methods:
*   `verify(mock).method()`: Asserts that the method was called exactly 1 time.
*   `verify(mock, times(n)).method()`: Asserts that the method was called exactly `n` times.
*   `verify(mock, never()).method()`: Asserts that the method was never called.
*   `verifyNoInteractions(mock)`: Asserts that no methods were called on the mock at all.

---

### Project Structure

```text
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── example
    │               ├── ExternalApi.java
    │               └── MyService.java
    └── test
        └── java
            └── com
                └── example
                    └── MyServiceTest.java
```

---

### Implementation Code

#### 1. External API Interface (`ExternalApi.java`)
[ExternalApi.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Verifying%20Interactions/src/main/java/com/example/ExternalApi.java)
```java
package com.example;

public interface ExternalApi {
    String getData();
}
```

#### 2. Target Service under Test (`MyService.java`)
[MyService.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Verifying%20Interactions/src/main/java/com/example/MyService.java)
```java
package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}
```

#### 3. JUnit & Mockito Test (`MyServiceTest.java`)
[MyServiceTest.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Verifying%20Interactions/src/test/java/com/example/MyServiceTest.java)
```java
package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest { 

    @Test 
    public void testVerifyInteraction() { 
        // 1. Create a mock object.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        
        // 2. Call the method with specific arguments / interactions.
        MyService service = new MyService(mockApi); 
        service.fetchData(); 
        
        // 3. Verify the interaction.
        verify(mockApi).getData(); 
    } 
}
```

---

### How to Run the Tests

Open your terminal, navigate to the `Module 4/Mokito excercise - Verifying Interactions` folder, and run:
```bash
mvn test
```

**Execution Logs Output:**
```text
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< com.example:mockito-verification-demo >----------------
[INFO] Building mockito-verification-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] --- surefire:3.2.2:test (default-test) @ mockito-verification-demo ---
[INFO] Running com.example.MyServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.622 s -- in com.example.MyServiceTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
The test runs successfully, confirming that the mock API interaction was verified.
