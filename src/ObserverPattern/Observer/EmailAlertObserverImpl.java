package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    StocksObservable stocksObservable;
    String emailId;

    public EmailAlertObserverImpl(StocksObservable stocksObservable, String emailId){
        this.stocksObservable = stocksObservable;
        this.emailId = emailId;
    }
    @Override
    public void update() {
        int count = stocksObservable.getStockCount();
        System.out.println("Send email: " + emailId + " " + count);
    }
}
