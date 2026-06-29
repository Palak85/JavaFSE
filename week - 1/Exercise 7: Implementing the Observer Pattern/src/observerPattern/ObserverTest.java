package observerPattern;

public class ObserverTest {
    public static void test() {
        System.out.println("=== Observer Pattern Test ===");

        // Create Stock Market (Subject)
        StockMarket stockMarket = new StockMarket();

        // Create Observers
        Observer mobileApp1 = new MobileApp("TradePro");
        Observer mobileApp2 = new MobileApp("RobinhoodLite");
        Observer webDashboard = new WebApp("FinanceGrid");

        // Register Observers
        System.out.println("--- Registering Observers ---");
        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webDashboard);
        System.out.println();

        // Update Stock Price (All should receive updates)
        System.out.println("--- Stock Update 1 ---");
        stockMarket.setStockData("AAPL (Apple Inc.)", 185.50);
        System.out.println();

        // Update Stock Price 2
        System.out.println("--- Stock Update 2 ---");
        stockMarket.setStockData("GOOGL (Alphabet Inc.)", 172.10);
        System.out.println();

        // Deregister one observer
        System.out.println("--- Deregistering TradePro Mobile App ---");
        stockMarket.deregister(mobileApp1);
        System.out.println();

        // Update Stock Price 3 (TradePro should NOT receive updates)
        System.out.println("--- Stock Update 3 ---");
        stockMarket.setStockData("MSFT (Microsoft Corp.)", 420.30);
        System.out.println();
    }
}
