package taskManagement;

public class TaskTest {
    public static void test() {
        System.out.println("=== Task Management System Test ===");

        // Create Task Linked List
        TaskLinkedList taskList = new TaskLinkedList();

        // 1. Add Tasks
        System.out.println("--- 1. Adding Tasks ---");
        taskList.addTask(new Task("T001", "Design Database Schema", "Done"));
        taskList.addTask(new Task("T002", "Implement REST APIs", "In Progress"));
        taskList.addTask(new Task("T003", "Write Unit Tests", "Pending"));
        taskList.addTask(new Task("T004", "Setup CI/CD Pipeline", "Pending"));
        System.out.println();

        // 2. Traverse Tasks
        System.out.println("--- 2. Traversing Tasks ---");
        taskList.traverseTasks();
        System.out.println();

        // 3. Search Task
        System.out.println("--- 3. Searching for Task T002 ---");
        Task found = taskList.searchTask("T002");
        System.out.println("Result: " + (found != null ? found : "Not Found"));
        System.out.println();

        // 4. Delete Task
        System.out.println("--- 4. Deleting Task T003 ---");
        taskList.deleteTask("T003");
        System.out.println();

        // 5. Traverse Tasks again
        System.out.println("--- 5. Traversing Tasks (Post-Deletion) ---");
        taskList.traverseTasks();
        System.out.println();

        // 6. Analysis and Discussion
        System.out.println("=== Analysis and Discussion ===");
        System.out.println("1. Linked List Types:");
        System.out.println("   - Singly Linked List: Each node contains data and a pointer to the NEXT node. Traversal is uni-directional.");
        System.out.println("   - Doubly Linked List: Each node contains data, a pointer to the NEXT node, and a pointer to the PREVIOUS node. Allows bi-directional traversal.");
        System.out.println();
        System.out.println("2. Operation Time Complexities in this Singly Linked List:");
        System.out.println("   - Add Task: O(n) (traverses to the end of list; would be O(1) if keeping a tail pointer reference).");
        System.out.println("   - Search Task: O(n) (requires linear scan from head).");
        System.out.println("   - Traverse Tasks: O(n) (visits every node from head to tail).");
        System.out.println("   - Delete Task: O(n) (requires traversing to find the node and its predecessor).");
        System.out.println();
        System.out.println("3. Advantages of Linked Lists Over Arrays:");
        System.out.println("   - Dynamic Size: No fixed capacity. Nodes are allocated dynamically in memory as needed, preventing memory waste.");
        System.out.println("   - Fast Insertion/Deletion: Once the position node is found, insertions/deletions take O(1) time by reassigning next-node pointer references (no element shifting required).");
        System.out.println("   - No Memory Fragmentation: Allocates nodes scattered throughout heap space rather than requiring a single contiguous memory block.");
        System.out.println();
    }
}
