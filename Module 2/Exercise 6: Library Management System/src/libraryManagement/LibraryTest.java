package libraryManagement;

import java.util.Arrays;

public class LibraryTest {
    public static void test() {
        System.out.println("=== Library Management System Search Test ===");

        // Setup unsorted books array
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger")
        };

        // 1. Linear Search Test (Unsorted)
        System.out.println("--- 1. Linear Search (Target: '1984') ---");
        Book linearResult = Library.linearSearchByTitle(books, "1984");
        System.out.println("Result: " + (linearResult != null ? linearResult : "Not Found"));
        System.out.println();

        // 2. Binary Search Test (Requires Sorted Array)
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks); // Sorts by title using compareTo in Book

        System.out.println("--- Sorted Books for Binary Search ---");
        for (Book book : sortedBooks) {
            System.out.println("  " + book);
        }
        System.out.println();

        System.out.println("--- 2. Binary Search (Target: 'Pride and Prejudice') ---");
        Book binaryResult = Library.binarySearchByTitle(sortedBooks, "Pride and Prejudice");
        System.out.println("Result: " + (binaryResult != null ? binaryResult : "Not Found"));
        System.out.println();

        // 3. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Linear Search vs. Binary Search Complexity:");
        System.out.println("   - Linear Search: Time Complexity O(n). It scans each item one by one.");
        System.out.println("   - Binary Search: Time Complexity O(log n). It repeatedly divides the search space in half.");
        System.out.println();
        System.out.println("2. When to Use Linear Search:");
        System.out.println("   - Small datasets: The difference in runtime is negligible, and no sorting overhead is needed.");
        System.out.println("   - Unsorted/Frequently Changing data: If sorting takes O(n log n) and we only search occasionally, sorting first is inefficient.");
        System.out.println("   - Linked Lists: Random access is O(n), so binary search cannot run in O(log n) time on standard linked lists.");
        System.out.println();
        System.out.println("3. When to Use Binary Search:");
        System.out.println("   - Large, static datasets: E.g., a library catalog with millions of books. A linear search would take too long, while binary search takes only ~20 steps.");
        System.out.println("   - Sorted databases/arrays: When the data is already stored sorted, always use binary search for lookup.");
        System.out.println();
    }
}
