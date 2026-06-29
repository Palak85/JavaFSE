package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers;
    private String stockName;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    // Set stock price and trigger notifications
    public void setStockData(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        System.out.println("StockMarket Update: " + stockName + " is now $" + price);
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        System.out.println("Registered observer: " + o.getClass().getSimpleName());
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
        System.out.println("Deregistered observer: " + o.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
