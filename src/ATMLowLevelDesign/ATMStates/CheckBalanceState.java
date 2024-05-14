package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.Card;

public class CheckBalanceState extends ATMState {
    @Override
    public void displayBalance(ATM atm, Card card) {
        int balance = card.getUserBankAccount().getBankBalance();
        System.out.println("Your balance is:" + balance);
    }

    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Card returned and exiting user");
    }

    @Override
    public void returnCard() {
        System.out.println("Card returned, please collect your card");
    }
}
