package dependencyInjection;

public class DITest {
    public static void test() {
        System.out.println("=== Dependency Injection Test ===");

        // 1. Create concrete dependency
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Inject dependency into service via Constructor Injection
        CustomerService service = new CustomerService(repository);

        // 3. Test service behavior
        System.out.println("--- Test 1: Fetch Existing Customer (ID 1) ---");
        service.displayCustomerDetails(1);
        System.out.println();

        System.out.println("--- Test 2: Fetch Existing Customer (ID 2) ---");
        service.displayCustomerDetails(2);
        System.out.println();

        System.out.println("--- Test 3: Fetch Non-existent Customer (ID 99) ---");
        service.displayCustomerDetails(99);
        System.out.println();
    }
}
