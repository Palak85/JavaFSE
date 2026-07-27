# SLF4J Logging: Exercise 1 - Logging Error Messages and Warning Levels

This project demonstrates how to implement application logging using the standard **SLF4J API** with a **Logback Classic** backing provider to trace messages at the `ERROR` and `WARN` levels.

---

### Key Concepts

#### 1. What is SLF4J?
The **Simple Logging Facade for Java (SLF4J)** acts as a simple abstraction layer for various logging frameworks (e.g., java.util.logging, log4j2, Logback). By programming to the SLF4J interface, you can switch logging providers at deployment time without modifying your code.

#### 2. Logging Levels
Logging frameworks sort logs by severity levels. The standard levels (sorted from lowest to highest severity) are:
1.  `TRACE`
2.  `DEBUG`
3.  `INFO`
4.  `WARN` (Warnings of potential errors/failures)
5.  `ERROR` (Severe application faults/exceptions)

---

### Project Structure

```text
├── pom.xml
└── src
    └── main
        └── java
            └── LoggingExample.java
```

---

### Implementation Code

#### 1. Logging App class (`LoggingExample.java`)
[LoggingExample.java](file:///Users/palaksingh/Desktop/fse/SL4J%20Logging%20exercises/Exercise%201:%20Logging%20Error%20Messages%20and%20Warning%20Levels/src/main/java/LoggingExample.java)
```java
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

public class LoggingExample { 
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class); 
    
    public static void main(String[] args) { 
        logger.error("This is an error message"); 
        logger.warn("This is a warning message"); 
    } 
}
```

---

### How to Run the Application

Open your terminal, navigate to the `SL4J Logging exercises/Exercise 1: Logging Error Messages and Warning Levels` folder, and run:
```bash
mvn compile exec:java
```

**Execution Logs Output:**
```text
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.example:slf4j-logging-demo >------------------
[INFO] Building slf4j-logging-demo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] --- exec:3.1.1:java (default-cli) @ slf4j-logging-demo ---
18:52:51.168 [LoggingExample.main()] ERROR LoggingExample - This is an error message
18:52:51.169 [LoggingExample.main()] WARN LoggingExample - This is a warning message
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
Notice that the output formatting (timestamp, thread, class, level, and message) is handled automatically by Logback.
