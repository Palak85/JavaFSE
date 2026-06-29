package inventoryManagement;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add a product to inventory
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists. Use updateProduct.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // Update a product in inventory
    public void updateProduct(String productId, Product updatedProduct) {
        if (!products.containsKey(productId)) {
            System.out.println("Product with ID " + productId + " does not exist in inventory.");
            return;
        }
        products.put(productId, updatedProduct);
        System.out.println("Updated Product ID " + productId + " successfully: " + updatedProduct);
    }

    // Delete a product from inventory
    public void deleteProduct(String productId) {
        if (!products.containsKey(productId)) {
            System.out.println("Product with ID " + productId + " does not exist in inventory.");
            return;
        }
        Product removed = products.remove(productId);
        System.out.println("Deleted: " + removed);
    }

    // Get a specific product
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display all products
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Product product : products.values()) {
            System.out.println("  " + product);
        }
    }
}
