package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Initializing Spring Context (Constructor and Setter Injection) ===");
        
        // Load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("\n=== Fetching and testing bookServiceConstructor ===");
        BookService serviceConstructor = (BookService) context.getBean("bookServiceConstructor");
        serviceConstructor.manageBook();
        
        System.out.println("\n=== Fetching and testing bookServiceSetter ===");
        BookService serviceSetter = (BookService) context.getBean("bookServiceSetter");
        serviceSetter.manageBook();
        
        System.out.println("\n=== Exercise 7 Completed Successfully ===");
    }
}
