package searchFunction;

import java.util.Arrays;

public class SearchTest {
    public static void test() {
        System.out.println("=== E-commerce Platform Search Test ===");

        // Setup array of products
        Product[] products = {
            new Product("P103", "Noise Cancelling Headphones", "Audio"),
            new Product("P101", "MacBook Pro M3", "Computers"),
            new Product("P105", "Mechanical Keyboard", "Accessories"),
            new Product("P102", "iPhone 15 Pro", "Mobile Phones"),
            new Product("P104", "4K Ultra-Wide Monitor", "Displays")
        };

        // 1. Linear Search Test (Unsorted Array)
        System.out.println("--- 1. Linear Search (Target ID: P102) ---");
        Product linearResult = SearchAlgorithms.linearSearch(products, "P102");
        System.out.println("Result: " + (linearResult != null ? linearResult : "Not Found"));
        System.out.println();

        // 2. Binary Search Test (Requires Sorted Array)
        // Sort the array by productId (using Comparable compareTo implemented in Product)
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);

        System.out.println("--- Sorted Products for Binary Search ---");
        for (Product product : sortedProducts) {
            System.out.println("  " + product);
        }
        System.out.println();

        System.out.println("--- 2. Binary Search (Target ID: P102) ---");
        Product binaryResult = SearchAlgorithms.binarySearch(sortedProducts, "P102");
        System.out.println("Result: " + (binaryResult != null ? binaryResult : "Not Found"));
        System.out.println();

        // 3. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Big O Notation & Search Performance Analysis:");
        System.out.println("   - Big O notation describes the upper bound of an algorithm's execution time in terms of input size (n).");
        System.out.println("   - Search Scenarios:");
        System.out.println("     - Best-Case: O(1) for both linear and binary search (item found at first index or midpoint).");
        System.out.println("     - Average-Case: Linear Search is O(n/2) -> O(n); Binary Search is O(log n) average steps.");
        System.out.println("     - Worst-Case: Linear Search is O(n) (item is at the end or not present); Binary Search is O(log n).");
        System.out.println();
        System.out.println("2. Linear Search vs. Binary Search Complexity Comparison:");
        System.out.println("   - Linear Search:");
        System.out.println("     - Time Complexity: O(n)");
        System.out.println("     - Space Complexity: O(1)");
        System.out.println("     - Prerequisite: Works on unsorted arrays. Extremely simple to implement.");
        System.out.println("   - Binary Search:");
        System.out.println("     - Time Complexity: O(log n)");
        System.out.println("     - Space Complexity: O(1)");
        System.out.println("     - Prerequisite: Requires the array to be sorted beforehand.");
        System.out.println();
        System.out.println("3. Suitability Selection:");
        System.out.println("   - For search-heavy systems like e-commerce catalogs with millions of items, Binary Search is far superior.");
        System.out.println("   - Although sorting requires initial computational overhead O(n log n), once sorted, we can search repeatedly in logarithmic time O(log n).");
        System.out.println("   - For very small arrays or when array changes constantly (frequent insertions/deletions), sorting overhead makes linear search more practical.");
        System.out.println();
    }
}
