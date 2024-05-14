package ATMLowLevelDesign.ATMStates;

import ATMLowLevelDesign.ATM;
import ATMLowLevelDesign.Card;

public class HasCardState extends ATMState {
    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("Authenticating user pin");
        boolean isVerified = card.verifyPin(pin);
        if (isVerified) {
            SelectOperationState newSelectOperation = new SelectOperationState();
            atm.setAtmState(newSelectOperation);
            /*
            // this below can also be called in the constructor of SelectOperationState
            newSelectOperation.showAvailableOperations();
            */
        } else {
            System.out.println("Incorrect PIN entered");
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
