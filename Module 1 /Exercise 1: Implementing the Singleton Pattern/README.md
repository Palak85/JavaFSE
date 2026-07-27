# Logger Singleton Implementation

This document describes the implementation of the **Singleton Design Pattern** in Java for a `Logger` class, ensuring a single instance for consistent logging throughout the application.

## Directory Structure
- **bin/**: Contains compiled `.class` files.
- **output/**: Contains a screenshot of the program output.
- **src/**: Contains source `.java` files.
  - `Main/Main.java`: Entry point for testing the Singleton.
  - `singletonPattern/Logger.java`: Singleton class for logging.
  - `singletonPattern/SingletonTest.java`: Test class to verify Singleton behavior.

## Code Description

### Logger Class (`src/singletonPattern/Logger.java`)

Below is the implementation of the `Logger` class, which follows a thread-safe Singleton pattern:

```java
package singletonPattern;

public class Logger {
    // Volatile static instance of the class to prevent instruction reordering issues
    private static volatile Logger logger = null;
    
    private Logger() {
        // Guard against reflection instantiation
        if (logger != null) {
            throw new IllegalStateException("Logger instance already exists. Use getLoggerInstance().");
        }
    }
    
    // Thread-safe getLoggerInstance using Double-Checked Locking
    public static Logger getLoggerInstance() {
        if (logger == null) { // First check (no lock)
            synchronized (Logger.class) {
                if (logger == null) { // Second check (with lock)
                    logger = new Logger();
                }
            }
        }  
        return logger;
    }
    
    // Sample logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
```

#### Key Features:
- **Private Static Volatile Instance**: `private static volatile Logger logger = null` holds the single instance and ensures cache visibility across threads.
- **Private Constructor with Guard**: `private Logger()` prevents external instantiation and guards against reflection attacks.
- **Double-Checked Locking (Thread Safety)**: `getLoggerInstance()` checks if `logger` is null twice with synchronized block locking in between to guarantee safe concurrent instantiation with minimal overhead.
- **Logging Method**: `log(String message)` outputs messages to the console, prefixed with "Log: ".

## Testing the Singleton

The `SingletonTest.java` class (located in `src/singletonPattern/`) tests the Singleton by:
1. Obtaining two instances via `Logger.getLoggerInstance()` in a single thread to confirm they refer to the exact same reference.
2. Spawning 10 concurrent threads that simultaneously access `Logger.getLoggerInstance()` to verify thread safety (expecting exactly one unique instance across all threads).

```java
package singletonPattern;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingletonTest {
    public static void test() {
        System.out.println("--- Test 1: Single-Threaded Verification ---");
        Logger logger1 = Logger.getLoggerInstance();
        Logger logger2 = Logger.getLoggerInstance();
        
        logger1.log("This is logger1");
        logger2.log("This is logger2");

        System.out.println();

        // Testing if both logger1 & logger2 point to the same instance or not
        boolean isSame = (logger1 == logger2);
        System.out.println("Are logger1 and logger2 the same instance?? " + isSame);
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());
        System.out.println();

        System.out.println("--- Test 2: Thread-Safety Verification (Multi-Threaded) ---");
        Set<Logger> loggerInstances = Collections.newSetFromMap(new ConcurrentHashMap<>());
        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i + 1;
            executor.submit(() -> {
                Logger instance = Logger.getLoggerInstance();
                loggerInstances.add(instance);
                instance.log("Log from thread #" + threadId + " (Instance Hash: " + instance.hashCode() + ")");
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println("Number of unique Logger instances created across threads: " + loggerInstances.size());
        if (loggerInstances.size() == 1) {
            System.out.println("SUCCESS: Thread-safety verified. Single instance preserved.");
        } else {
            System.out.println("FAILURE: Multiple instances detected!");
        }
        System.out.println();
    }
}
```

## Conclusion
This `Logger` class successfully demonstrates a robust, thread-safe Singleton design pattern matching all criteria of Exercise 1.
