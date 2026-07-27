# Spring Core Dependency Injection (Module 4 Exercise 2)

This project demonstrates the configuration of **Spring's XML-based Dependency Injection** in a Java library application using Maven.

## Directory Structure
- **pom.xml**: Maven configuration containing the `spring-context` dependency.
- **src/main/resources/applicationContext.xml**: XML configurations wiring `BookRepository` bean into `BookService` bean.
- **src/main/java/com/library/repository/BookRepository.java**: Simulates data repository saving logic.
- **src/main/java/com/library/service/BookService.java**: Declares private BookRepository and provides setter injection hooks.
- **src/main/java/com/library/LibraryManagementApplication.java**: Executable entry point initializing context and triggering service functions.
- **README.md**: Documentation.

---

## 1. Bean Configuration (`applicationContext.xml`)
We register the beans and configure dependency injection using the `<property>` tag, which maps to the `setBookRepository(...)` setter method in `BookService`:

```xml
<!-- Define BookRepository bean -->
<bean id="bookRepository" class="com.library.repository.BookRepository"/>

<!-- Define BookService bean and wire BookRepository using setter injection -->
<bean id="bookService" class="com.library.service.BookService">
    <property name="bookRepository" ref="bookRepository"/>
</bean>
```

---

## 2. Test Execution Output
Upon running `LibraryManagementApplication.java` inside an IDE or building with Maven, you will see the following output in the console:

```
=== Initializing Spring Application Context ===
BookService: BookRepository has been wired/injected via setter method.

=== Context Initialized. Fetching BookService Bean ===

=== Executing Service Operations ===
BookService: Processing book management operation...
BookRepository: Book record has been successfully saved to the database.

=== Application Completed Successfully ===
```
