package adapterPattern;

public class PaypalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal Gateway.");
    }
}
