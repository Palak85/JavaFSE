package observerPattern;

public class WebApp implements Observer {
    private final String dashboardName;

    public WebApp(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Web Dashboard - " + dashboardName + "] Real-time Grid Update: " + stockName + " price is now $" + price);
    }
}
