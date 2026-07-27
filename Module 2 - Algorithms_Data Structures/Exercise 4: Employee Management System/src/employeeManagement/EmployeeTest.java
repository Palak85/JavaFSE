package employeeManagement;

public class EmployeeTest {
    public static void test() {
        System.out.println("=== Employee Management System Test ===");

        // Create manager with capacity of 5
        EmployeeManager manager = new EmployeeManager(5);

        // 1. Add Employees
        System.out.println("--- 1. Adding Employees ---");
        manager.addEmployee(new Employee("E101", "John Doe", "Software Engineer", 75000));
        manager.addEmployee(new Employee("E102", "Jane Smith", "Project Manager", 85000));
        manager.addEmployee(new Employee("E103", "Alice Johnson", "QA Analyst", 65000));
        manager.addEmployee(new Employee("E104", "Bob Brown", "HR Specialist", 60000));
        System.out.println();

        // 2. Traverse Directory
        System.out.println("--- 2. Traversing Directory ---");
        manager.traverseEmployees();
        System.out.println();

        // 3. Search Employee
        System.out.println("--- 3. Searching for Employee E102 ---");
        Employee found = manager.searchEmployee("E102");
        System.out.println("Result: " + (found != null ? found : "Not Found"));
        System.out.println();

        // 4. Delete Employee
        System.out.println("--- 4. Deleting Employee E103 ---");
        manager.deleteEmployee("E103");
        System.out.println();

        // 5. Traverse Directory again to confirm contiguous shifting
        System.out.println("--- 5. Traversing Directory (Post-Deletion) ---");
        manager.traverseEmployees();
        System.out.println();

        // 6. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Array Representation in Memory and Advantages:");
        System.out.println("   - Arrays are stored in contiguous memory blocks. Each element is accessible via index offset calculations.");
        System.out.println("   - Advantage - O(1) Access: Because of contiguous memory, accessing any index takes constant time using the formula: Base Address + Index * Size.");
        System.out.println("   - Advantage - Cache Friendliness: Contiguous storage maximizes spatial CPU cache locality, yielding fast iterations.");
        System.out.println();
        System.out.println("2. Operation Time Complexities in this Implementation:");
        System.out.println("   - Add Operation: O(1) (when inserting at the end of the array and keeping a count pointer).");
        System.out.println("   - Search Operation: O(n) (requires linear scan to find a matching employeeId).");
        System.out.println("   - Traverse Operation: O(n) (visits all n active employee slots).");
        System.out.println("   - Delete Operation: O(n) (requires shifting remaining elements to close the gap after removal).");
        System.out.println();
        System.out.println("3. Limitations of Arrays and Alternatives:");
        System.out.println("   - Fixed Size: Cannot dynamically resize. Growing requires allocating a new array and copying elements (O(n)).");
        System.out.println("   - Costly Insertions/Deletions: Inserting/deleting in the middle requires shifting elements (O(n)).");
        System.out.println("   - Alternatives:");
        System.out.println("     - Use Linked List: When frequent additions/deletions are needed and sizing is dynamic.");
        System.out.println("     - Use Hash Map: When instant lookups (O(1)) by ID are required.");
        System.out.println();
    }
}
