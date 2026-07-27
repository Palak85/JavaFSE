package sortingOrders;

import java.util.Arrays;

public class SortingTest {
    public static void test() {
        System.out.println("=== Sorting Customer Orders Test ===");

        // Setup test orders
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 89.90),
            new Order("O003", "Charlie", 450.00),
            new Order("O004", "David", 120.00),
            new Order("O005", "Emma", 310.20)
        };

        System.out.println("--- Original Orders ---");
        printOrders(orders);
        System.out.println();

        // 1. Bubble Sort Test
        System.out.println("--- 1. Sorting using Bubble Sort ---");
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.bubbleSort(bubbleSortedOrders);
        printOrders(bubbleSortedOrders);
        System.out.println();

        // 2. Quick Sort Test
        System.out.println("--- 2. Sorting using Quick Sort ---");
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        printOrders(quickSortedOrders);
        System.out.println();

        // 3. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Understanding Sorting Algorithms:");
        System.out.println("   - Bubble Sort: Compares adjacent elements and swaps them if they are in wrong order. Repeated until sorted. Time: O(n^2).");
        System.out.println("   - Insertion Sort: Builds the sorted array one element at a time by inserting elements into their correct position. Time: O(n^2).");
        System.out.println("   - Quick Sort: Divide-and-conquer algorithm. Chooses a pivot, partitions array around pivot, and sorts sub-arrays recursively. Time: O(n log n) average.");
        System.out.println("   - Merge Sort: Divide-and-conquer algorithm. Splits array in halves, recursively sorts them, and merges sorted halves. Time: O(n log n) stable.");
        System.out.println();
        System.out.println("2. Bubble Sort vs. Quick Sort Complexity Comparison:");
        System.out.println("   - Bubble Sort:");
        System.out.println("     - Best-Case: O(n) (when array is already sorted, optimized with swapped flag).");
        System.out.println("     - Average & Worst-Case: O(n^2).");
        System.out.println("     - Space Complexity: O(1) (in-place).");
        System.out.println("   - Quick Sort:");
        System.out.println("     - Best & Average-Case: O(n log n).");
        System.out.println("     - Worst-Case: O(n^2) (occurs when pivot splits array extremely unbalanced, e.g., already sorted array and choosing first/last element as pivot).");
        System.out.println("     - Space Complexity: O(log n) average (due to recursive call stack).");
        System.out.println();
        System.out.println("3. Why Quick Sort is Preferred Over Bubble Sort:");
        System.out.println("   - Bubble Sort's O(n^2) time complexity is extremely slow for large datasets. Sorting 100,000 orders would take billions of comparisons.");
        System.out.println("   - Quick Sort averages O(n log n), which requires only millions of operations for the same dataset, running thousands of times faster.");
        System.out.println("   - Quick Sort has excellent cache locality and performs very few actual swaps compared to Bubble Sort, making its inner loop highly efficient.");
        System.out.println();
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("  " + order);
        }
    }
}
