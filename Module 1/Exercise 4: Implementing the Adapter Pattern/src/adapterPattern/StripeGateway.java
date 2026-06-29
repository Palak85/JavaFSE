package adapterPattern;

public class StripeGateway {
    public void chargeCustomer(double amount) {
        System.out.println("Charging static customer with amount $" + amount + " through Stripe API.");
    }
}
