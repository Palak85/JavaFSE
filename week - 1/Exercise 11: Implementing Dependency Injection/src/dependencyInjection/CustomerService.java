package dependencyInjection;

public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomerDetails(int id) {
        String details = repository.findCustomerById(id);
        System.out.println("Customer Profile Lookup Result:");
        System.out.println(details);
    }
}
