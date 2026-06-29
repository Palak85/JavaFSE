package adapterPattern;

public class AdapterTest {
    public static void test() {
        System.out.println("=== Adapter Pattern Test ===");

        // Test PayPal Gateway through its adapter
        PaypalGateway paypalGateway = new PaypalGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalGateway);
        System.out.println("Using PayPal Adapter:");
        paypalProcessor.processPayment(150.00);
        System.out.println();

        // Test Stripe Gateway through its adapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        System.out.println("Using Stripe Adapter:");
        stripeProcessor.processPayment(320.50);
        System.out.println();
    }
}
