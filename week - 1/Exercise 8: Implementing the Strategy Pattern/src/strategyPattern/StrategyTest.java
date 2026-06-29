package strategyPattern;

public class StrategyTest {
    public static void test() {
        System.out.println("=== Strategy Pattern Test ===");

        PaymentContext context = new PaymentContext();

        // 1. Pay using Credit Card
        System.out.println("--- Test 1: Paying with Credit Card ---");
        PaymentStrategy creditCard = new CreditCardPayment(
                "John Doe", "1234567890123456", "123", "12/28"
        );
        context.setPaymentStrategy(creditCard);
        context.executePayment(250.75);
        System.out.println();

        // 2. Pay using PayPal
        System.out.println("--- Test 2: Paying with PayPal ---");
        PaymentStrategy payPal = new PayPalPayment(
                "john.doe@example.com", "my_secure_password"
        );
        context.setPaymentStrategy(payPal);
        context.executePayment(89.90);
        System.out.println();
    }
}
