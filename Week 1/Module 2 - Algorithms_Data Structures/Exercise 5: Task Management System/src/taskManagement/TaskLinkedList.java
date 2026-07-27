package taskManagement;

public class TaskLinkedList {
    // Nested Node class
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // 1. Add Task (at the end of the list)
    // Time Complexity: O(n) (or O(1) if keeping a tail pointer; let's traverse to the end to show standard lookup)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + task.getTaskName());
    }

    // 2. Search Task by ID
    // Time Complexity: O(n)
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // 3. Traverse and display tasks
    // Time Complexity: O(n)
    public void traverseTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("Task List:");
        Node current = head;
        while (current != null) {
            System.out.println("  " + current.task);
            current = current.next;
        }
    }

    // 4. Delete Task by ID
    // Time Complexity: O(n)
    public boolean deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Error: Task list is empty.");
            return false;
        }

        // If head node itself holds the key to be deleted
        if (head.task.getTaskId().equals(taskId)) {
            Task removed = head.task;
            head = head.next;
            System.out.println("Deleted task: " + removed.getTaskName());
            return true;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                prev.next = current.next;
                System.out.println("Deleted task: " + current.task.getTaskName());
                return true;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Error: Task with ID " + taskId + " not found.");
        return false;
    }
}
