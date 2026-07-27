package inventoryManagement;

public class InventoryTest {
    public static void test() {
        System.out.println("=== Inventory Management System Test ===");

        // Initialize Inventory
        Inventory inventory = new Inventory();

        // 1. Add Products
        System.out.println("--- 1. Adding Products ---");
        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Wireless Headphones", 50, 89.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        System.out.println();

        // Display current inventory
        inventory.displayAllProducts();
        System.out.println();

        // 2. Update Product
        System.out.println("--- 2. Updating Product P002 (Smartphone) ---");
        Product p2Updated = new Product("P002", "Smartphone Pro", 20, 549.99);
        inventory.updateProduct("P002", p2Updated);
        System.out.println();

        // 3. Delete Product
        System.out.println("--- 3. Deleting Product P003 ---");
        inventory.deleteProduct("P003");
        System.out.println();

        // Display final inventory
        inventory.displayAllProducts();
        System.out.println();

        // 4. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Why Data Structures & Algorithms are Essential for Large Inventories:");
        System.out.println("   - With large inventories (thousands to millions of products), simple linear searches take O(n) time.");
        System.out.println("   - Choosing appropriate data structures allows fast lookup, updates, and deletes, saving latency and server load.");
        System.out.println("   - Efficient structures minimize memory usage and optimize storage performance.");
        System.out.println();
        System.out.println("2. Suitable Data Structures:");
        System.out.println("   - HashMap / HashTable: Provides average O(1) time complexity for insert, delete, and search operations, making it highly suitable for unique key lookups.");
        System.out.println("   - ArrayList / LinkedList: O(1) for adding, but O(n) for searching or deleting by key since they require scanning the whole list.");
        System.out.println("   - TreeMap: Keeps keys sorted, allowing range queries or sorted output, but operations take O(log n) time.");
        System.out.println();
        System.out.println("3. Time Complexity of HashMap Operations in this Implementation:");
        System.out.println("   - Add Operation: O(1) average (O(n) worst-case if key hash collisions lead to bucket resizing or tree traversal).");
        System.out.println("   - Update Operation: O(1) average (requires lookup by key and re-inserting updated object).");
        System.out.println("   - Delete Operation: O(1) average (removes key-value pair directly).");
        System.out.println();
        System.out.println("4. Optimization Suggestions:");
        System.out.println("   - Optimize HashMap by setting an appropriate initial capacity and load factor to avoid frequent rehashing.");
        System.out.println("   - Use thread-safe versions like ConcurrentHashMap if accessed by concurrent warehouse threads.");
        System.out.println("   - Implement secondary indexing (e.g. by category or name) if searching by attributes other than productId is required.");
        System.out.println();
    }
}
