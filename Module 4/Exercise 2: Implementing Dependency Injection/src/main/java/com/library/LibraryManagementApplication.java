package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Initializing Spring Application Context ===");
        
        // Load the XML configuration from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("\n=== Context Initialized. Fetching BookService Bean ===");
        
        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("\n=== Executing Service Operations ===");
        
        // Verify dependency injection by calling service operations
        bookService.manageBook();
        
        System.out.println("\n=== Application Completed Successfully ===");
    }
}
