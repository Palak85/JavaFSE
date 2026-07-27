# Module 4: Mockito - Mocking and Stubbing

This project illustrates how to test a Java service dependency using **Mockito** to mock external dependencies and stub their API method behaviors.

---

### Key Concepts

#### 1. What is Mocking?
Mocking is the act of creating a simulated clone of a real service or class that has a predefined interface but does not execute real application database calls, file reading operations, or network connections. Mocking allows developers to isolate the unit of code under test.

#### 2. What is Stubbing?
Stubbing is the process of defining dynamic or static return values for method calls made to a mocked object. Using Mockito's `when(...).thenReturn(...)` syntax, developers declare precisely what a mock method should return when triggered.

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
[ExternalApi.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Mocking%20and%20Stubbing%20/src/main/java/com/example/ExternalApi.java)
```java
package com.example;

public interface ExternalApi {
    String getData();
}
```

#### 2. Target Service under Test (`MyService.java`)
[MyService.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Mocking%20and%20Stubbing%20/src/main/java/com/example/MyService.java)
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
[MyServiceTest.java](file:///Users/palaksingh/Desktop/fse/Module%204/Mokito%20excercise%20-%20Mocking%20and%20Stubbing%20/src/test/java/com/example/MyServiceTest.java)
```java
package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest { 

    @Test 
    public void testExternalApi() { 
        // 1. Create a mock object for the external API. 
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        
        // 2. Stub the methods to return predefined values. 
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        // 3. Write a test case that uses the mock object. 
        MyService service = new MyService(mockApi); 
        String result = service.fetchData(); 
        
        assertEquals("Mock Data", result); 
    } 
}
```

---

### How to Run the Tests

Open your terminal, navigate to the `Module 4/Mokito excercise - Mocking and Stubbing ` folder, and run:
```bash
mvn test
```

**Execution Logs Output:**
```text
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.example:mockito-stubbing-demo >------------------
[INFO] Building mockito-stubbing-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] --- surefire:3.2.2:test (default-test) @ mockito-stubbing-demo ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] Running com.example.MyServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.352 s -- in com.example.MyServiceTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
The test runs successfully, showing that the dependency was mocked and stubbed correctly.
