package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("=== Exercise 9: Spring Boot LibraryManagement Application Started Successfully ===");
    }

    @Bean
    public CommandLineRunner seedDatabase(BookRepository repository) {
        return args -> {
            System.out.println("Seeding database with sample books...");
            repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
            repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
            repository.save(new Book("1984", "George Orwell", "9780451524935"));
            System.out.println("Database seeded successfully. Current books count: " + repository.count());
        };
    }
}
