package adapterPattern;

public class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translates target method processPayment to adaptee method sendPayment
        paypalGateway.sendPayment(amount);
    }
}
