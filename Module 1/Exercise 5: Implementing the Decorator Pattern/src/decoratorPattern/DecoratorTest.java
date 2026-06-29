package decoratorPattern;

public class DecoratorTest {
    public static void test() {
        System.out.println("=== Decorator Pattern Test ===");

        // 1. Basic Notifier (Email only)
        System.out.println("--- Test 1: Sending Basic Email Notification ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System Update: Backup complete!");
        System.out.println();

        // 2. Decorating with SMS (Email + SMS)
        System.out.println("--- Test 2: Sending Email + SMS Notification ---");
        Notifier smsAndEmail = new SMSNotifierDecorator(new EmailNotifier());
        smsAndEmail.send("Security Alert: New login detected!");
        System.out.println();

        // 3. Decorating with SMS and Slack (Email + SMS + Slack)
        System.out.println("--- Test 3: Sending Email + SMS + Slack Notification ---");
        Notifier multiChannelNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );
        multiChannelNotifier.send("Critical System Error: Database is offline!");
        System.out.println();
    }
}
