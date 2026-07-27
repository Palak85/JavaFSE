package proxyPattern;

public class ProxyImage implements Image {
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Lazy initialization: Create the RealImage object only when needed
        if (realImage == null) {
            System.out.println("ProxyImage: Cache miss. Instantiating RealImage for '" + filename + "'...");
            realImage = new RealImage(filename);
        } else {
            System.out.println("ProxyImage: Cache hit. Returning cached instance for '" + filename + "'.");
        }
        // Delegate display operation
        realImage.display();
    }
}
