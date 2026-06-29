package strategyPattern;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardName;
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardPayment(String cardName, String cardNumber, String cvv, String expiryDate) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
        System.out.println("Card Holder: " + cardName + " | Card Number: ****-****-****-" + 
                           cardNumber.substring(cardNumber.length() - 4));
    }
}
