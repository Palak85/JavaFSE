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
