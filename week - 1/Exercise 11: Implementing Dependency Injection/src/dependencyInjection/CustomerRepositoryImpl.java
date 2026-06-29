package dependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Mock data lookup
        if (id == 1) {
            return "Palak Singh (Customer ID: 1, Plan: Premium)";
        } else if (id == 2) {
            return "Alice Johnson (Customer ID: 2, Plan: Basic)";
        } else {
            return "Customer not found (ID: " + id + ")";
        }
    }
}
