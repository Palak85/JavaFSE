package employeeManagement;

public class EmployeeManager {
    private final Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    // 1. Add Employee
    // Time Complexity: O(1)
    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Error: Employee directory is full!");
            return false;
        }
        employees[count] = employee;
        count++;
        System.out.println("Employee added: " + employee.getName());
        return true;
    }

    // 2. Search Employee by ID
    // Time Complexity: O(n)
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // 3. Traverse Employees
    // Time Complexity: O(n)
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees in the directory.");
            return;
        }
        System.out.println("Employee Directory:");
        for (int i = 0; i < count; i++) {
            System.out.println("  " + employees[i]);
        }
    }

    // 4. Delete Employee by ID
    // Time Complexity: O(n) (requires shifting elements to fill the gap)
    public boolean deleteEmployee(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Error: Employee with ID " + employeeId + " not found.");
            return false;
        }

        Employee removed = employees[indexToDelete];
        // Shift remaining elements to the left to maintain contiguous block
        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null; // Clear last element reference
        count--;
        System.out.println("Deleted employee: " + removed.getName());
        return true;
    }

    public int getCount() {
        return count;
    }
}
