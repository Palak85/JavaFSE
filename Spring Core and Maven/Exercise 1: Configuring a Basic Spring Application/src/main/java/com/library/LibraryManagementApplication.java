package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Initializing Spring Application Context ===");
        
        // Load the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("\n=== Context Initialized. Fetching Beans ===");
        
        // Retrieve and test BookRepository bean
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.save();
        
        // Retrieve and test BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.manageBook();
        
        System.out.println("\n=== Exercise 1 Completed Successfully ===");
    }
}
