package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.Card;
import ATMLowLevelDesign.TransactionType;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showAvailableOperations();
    }

    public void showAvailableOperations() {
        System.out.println("Please select your desired operations");
        TransactionType.showAllOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        if (transactionType.equals(TransactionType.BALANCE_CHECK)) {
            System.out.println("You selected check balance operation");
            System.out.println("Changing machine state to CheckBalanceState");
            CheckBalanceState checkBalanceState = new CheckBalanceState();
            atm.setAtmState(checkBalanceState);
        } else if (transactionType.equals(TransactionType.CASH_WITHDRAW)) {
            System.out.println("You selected withdraw operation");
            System.out.println("Changing machine state to CashWithdrawState");
            CashWithdrawState cashWithdrawState = new CashWithdrawState();
            atm.setAtmState(cashWithdrawState);
        } else {
            System.out.println("Invalid operation");
            exit(atm);
        }
    }

    @Override
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
