package mvcPattern;

public class MVCTest {
    public static void test() {
        System.out.println("=== MVC Pattern Test ===");

        // Fetch student record from database/mock source
        Student student = retrieveStudentFromDatabase();

        // Create a view to write student details on console
        StudentView view = new StudentView();

        // Initialize Controller
        StudentController controller = new StudentController(student, view);

        // Display initial details via controller
        System.out.println("--- Initial State ---");
        controller.updateView();
        System.out.println();

        // Update student name and grade via controller
        System.out.println("--- Updating Student Details ---");
        controller.setStudentName("Palak Singh");
        controller.setStudentGrade("A+");
        System.out.println("Details updated via controller.");
        System.out.println();

        // Display updated details
        System.out.println("--- Updated State ---");
        controller.updateView();
        System.out.println();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Palak Kumari");
        student.setId("FSE-2026-0045");
        student.setGrade("A");
        return student;
    }
}
