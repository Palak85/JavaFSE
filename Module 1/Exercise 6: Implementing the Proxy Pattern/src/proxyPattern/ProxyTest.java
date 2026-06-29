package proxyPattern;

public class ProxyTest {
    public static void test() {
        System.out.println("=== Proxy Pattern Test ===");

        Image image1 = new ProxyImage("nature_photo.jpg");
        Image image2 = new ProxyImage("financial_report.pdf_page1.png");

        // First display call for image1 (should load from server - lazy initialization)
        System.out.println("--- Loading and Displaying Image 1 (First Time) ---");
        image1.display();
        System.out.println();

        // Second display call for image1 (should NOT load from server - cached)
        System.out.println("--- Displaying Image 1 Again (Cached) ---");
        image1.display();
        System.out.println();

        // First display call for image2 (should load from server)
        System.out.println("--- Loading and Displaying Image 2 (First Time) ---");
        image2.display();
        System.out.println();

        // Second display call for image2 (should NOT load from server)
        System.out.println("--- Displaying Image 2 Again (Cached) ---");
        image2.display();
        System.out.println();
    }
}
