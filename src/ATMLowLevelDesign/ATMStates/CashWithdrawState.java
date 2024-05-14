package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.Card;

public class CashWithdrawState extends ATMState {
    @Override
    public void cashWithdraw(ATM atm, Card card, int withdrawAmount) {
        int atmBalance = atm.getAtmBalance();
        int userBalance = card.getUserBankAccount().getBankBalance();
        if (atmBalance < withdrawAmount) {
            System.out.println("Insufficient funds in ATM");
            exit(atm);
        } else if (userBalance < withdrawAmount) {
            System.out.println("Insufficient funds in your account");
            exit(atm);
        } else {
            // int newBalance = atmBalance - withdrawAmount;
            // atm.setAtmBalance(newBalance);
            atm.deductAtmBalance(withdrawAmount);
            card.deductUserBalance(withdrawAmount);
        }
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
