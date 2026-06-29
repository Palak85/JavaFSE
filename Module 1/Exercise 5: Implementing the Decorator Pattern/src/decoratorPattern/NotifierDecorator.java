package decoratorPattern;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        // Delegate to the wrapped component
        wrappedNotifier.send(message);
    }
}
