package searchFunction;

public class SearchAlgorithms {

    // Linear Search Implementation
    // Time Complexity: O(n)
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation (Assumes products is sorted by productId)
    // Time Complexity: O(log n)
    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return sortedProducts[mid]; // Found
            } else if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }
}
