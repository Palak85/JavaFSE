package sortingOrders;

public class SortingAlgorithms {

    // 1. Bubble Sort Implementation
    // Time Complexity: O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped in inner loop, then array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // 2. Quick Sort Implementation
    // Time Complexity: O(n log n) average, O(n^2) worst case
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivotPrice = orders[high].getTotalPrice();
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (orders[j].getTotalPrice() <= pivotPrice) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i+1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}
