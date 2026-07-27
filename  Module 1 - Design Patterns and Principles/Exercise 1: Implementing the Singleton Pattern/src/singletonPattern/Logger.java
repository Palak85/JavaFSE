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