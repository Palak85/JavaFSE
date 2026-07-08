package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Initializing Spring Context (Annotation-based) ===");
        
        // Load the XML configuration from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("\n=== Context Initialized. Fetching BookService Bean ===");
        
        // Retrieve the BookService bean (id is automatically bookService by Spring component scanning)
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("\n=== Executing Service Operations ===");
        bookService.manageBook();
        
        System.out.println("\n=== Exercise 6 Completed Successfully ===");
    }
}
