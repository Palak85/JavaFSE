package decoratorPattern;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the wrapped notifier (e.g., Email)
        sendSMS(message);     // Add SMS functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
