package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

import java.util.List;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);
    public void notifySubscriber();
    public void setStockCount(int count);

    public int getStockCount();
}
