package builderPattern;

public class BuilderTest {
    public static void test() {
        System.out.println("=== Builder Pattern Test ===");

        // Creating a Basic Computer (only mandatory fields, minimal configuration)
        Computer basicComputer = new Computer.Builder("Intel Core i3", "8GB", "256GB SSD")
                .build();
        System.out.println("Basic Configuration:");
        System.out.println(basicComputer);
        System.out.println();

        // Creating a high-end Gaming PC (all fields configured)
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9 7950X", "32GB DDR5", "2TB NVMe SSD")
                .setGPU("NVIDIA GeForce RTX 4090")
                .setOS("Windows 11 Pro")
                .setWifi(true)
                .build();
        System.out.println("Gaming PC Configuration:");
        System.out.println(gamingPC);
        System.out.println();

        // Creating a developer workstation (some optional fields configured)
        Computer workstation = new Computer.Builder("Intel Core i7", "16GB", "1TB SSD")
                .setOS("Ubuntu 22.04 LTS")
                .setWifi(true)
                .build();
        System.out.println("Workstation Configuration:");
        System.out.println(workstation);
        System.out.println();
    }
}
