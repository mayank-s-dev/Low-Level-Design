package ObserverPattern.Observer;

import ObserverPattern.Observable.IphoneObservable;
import ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    StocksObservable stocksObservable;
    String username;

    public MobileAlertObserverImpl(StocksObservable stocksObservable, String emailId){
        this.stocksObservable = stocksObservable;
        this.username = emailId;
    }
    @Override
    public void update() {
        int count = stocksObservable.getStockCount();
        System.out.println("Send message on mobile: " + username + " " + count);
    }
}
