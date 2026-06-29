package proxyPattern;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image '" + filename + "' from remote server...");
        try {
            // Simulate network latency (e.g. 1 second)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Image '" + filename + "' successfully loaded from server.");
    }

    @Override
    public void display() {
        System.out.println("Displaying Real Image: " + filename);
    }
}
