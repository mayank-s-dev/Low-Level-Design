package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.AmountWithDrawal.CashWithDrawProcessor;
import ATMLowLevelDesign.AmountWithDrawal.FiveHundredWithDrawProcessor;
import ATMLowLevelDesign.AmountWithDrawal.OneHundredWithDrawProcessor;
import ATMLowLevelDesign.AmountWithDrawal.TwoThousandWithDrawProcessor;
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

            // using COR for withdraw and how many different types of notes are required
            CashWithDrawProcessor withdrawProcessor =
                    new TwoThousandWithDrawProcessor(new FiveHundredWithDrawProcessor(new OneHundredWithDrawProcessor(null)));

            withdrawProcessor.withdraw(atm, withdrawAmount);
            System.out.println("Remaining User Balance: " + card.getUserBankAccount().getBankBalance());
            exit(atm);
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
