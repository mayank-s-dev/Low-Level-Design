package ATMLowLevelDesign;

import ATMLowLevelDesign.ATMStates.ATMState;
import ATMLowLevelDesign.ATMStates.IdleState;

public class ATM {
    private static ATM atmObj = new ATM();

    ATMState atmState;
    private int atmBalance;
    int noOf2kNotes;

    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    public static ATM getAtmObj() {
        atmObj.setAtmState(new IdleState());
        return atmObj;
    }

    public void setAtmBalanceAndNotes(int atmBalance, int noOf2kNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOf2kNotes = noOf2kNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void printCurrentAtmStatus() {
        System.out.println("Balance: " + this.atmBalance);
        System.out.println("2kNotes: " + this.noOf2kNotes);
        System.out.println("500Notes: " + this.noOfFiveHundredNotes);
        System.out.println("100Notes: " + this.noOfOneHundredNotes);
    }

    public void deductAtmBalance(int withdrawAmount) {
        this.atmBalance -= withdrawAmount;
    }

    public static void setAtmObj(ATM atmObj) {
        ATM.atmObj = atmObj;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOf2kNotes() {
        return noOf2kNotes;
    }

    public void setNoOf2kNotes(int noOf2kNotes) {
        this.noOf2kNotes = noOf2kNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }


}
