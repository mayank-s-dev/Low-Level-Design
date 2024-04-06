package ObserverPattern;

import ObserverPattern.Observable.IphoneObservable;
import ObserverPattern.Observable.StocksObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.MobileAlertObserverImpl;
import ObserverPattern.Observer.NotificationAlertObserver;

public class store {
    public static void main(String args[]){
        StocksObservable stocksObservable = new IphoneObservable();
        NotificationAlertObserver notificationAlertObserver1 = new EmailAlertObserverImpl(stocksObservable, "mayanksahu.dev@gmail.com");
        NotificationAlertObserver notificationAlertObserver2 = new EmailAlertObserverImpl(stocksObservable, "harshit.xavier@gmail.com");
        NotificationAlertObserver notificationAlertObserver3 = new MobileAlertObserverImpl(stocksObservable, "harshit.xavier@gmail.com");

        stocksObservable.add(notificationAlertObserver1);
        stocksObservable.add(notificationAlertObserver2);
        stocksObservable.add(notificationAlertObserver3);

        stocksObservable.setStockCount(10);
    }
}
