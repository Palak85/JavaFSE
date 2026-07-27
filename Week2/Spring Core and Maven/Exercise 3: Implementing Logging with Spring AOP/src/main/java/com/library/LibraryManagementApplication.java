package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Initializing Spring Application Context ===");
        
        // Load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("\n=== Context Initialized. Fetching BookService Bean ===");
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("\n=== Executing Service Operations (Logging via AOP Aspect) ===");
        bookService.manageBook();
        
        System.out.println("\n=== Exercise 3 Completed Successfully ===");
    }
}
