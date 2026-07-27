package builderPattern;

public class Computer {
    // Attributes of the Computer
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String GPU;
    private final String OS;
    private final boolean hasWifi;

    // Private constructor taking Builder as a parameter
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
        this.hasWifi = builder.hasWifi;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGPU() { return GPU; }
    public String getOS() { return OS; }
    public boolean hasWifi() { return hasWifi; }

    @Override
    public String toString() {
        return "Computer {" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", Storage='" + storage + '\'' +
                ", GPU='" + (GPU != null ? GPU : "Integrated") + '\'' +
                ", OS='" + (OS != null ? OS : "None") + '\'' +
                ", Wi-Fi=" + (hasWifi ? "Enabled" : "Disabled") +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        // Mandatory/Optional parameters
        private final String CPU;
        private final String RAM;
        private final String storage;
        private String GPU;
        private String OS;
        private boolean hasWifi;

        // Constructor for the Builder requiring mandatory attributes
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Methods to set optional attributes (returns Builder for method chaining)
        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        public Builder setWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        // Build method to return the final Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
