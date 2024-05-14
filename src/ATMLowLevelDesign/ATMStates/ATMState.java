package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.Card;
import ATMLowLevelDesign.TransactionType;
import HandlingNullObj.Car;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("OOPS something went wrong");
    }

    public void cashWithdraw(ATM atm, Card card, int withdrawAmount) {
        System.out.println("OOPS something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS something went wrong");
    }
}
