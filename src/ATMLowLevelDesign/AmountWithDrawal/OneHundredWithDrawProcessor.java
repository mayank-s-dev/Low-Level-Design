package ATMLowLevelDesign.AmountWithDrawal;

import ATMLowLevelDesign.ATM;

public class OneHundredWithDrawProcessor extends CashWithDrawProcessor {
    public OneHundredWithDrawProcessor(CashWithDrawProcessor cashWithDrawProcessor) {
        super(cashWithDrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 100;
        int balance = remainingAmount % 100;
        int _100notesInAtm = atm.getNoOfOneHundredNotes();

        if (requiredNotes <= _100notesInAtm) {
            System.out.println("Used " + requiredNotes + " notes of 100");
            atm.deductOneHundredNotes(requiredNotes);
        } else {
            atm.deductOneHundredNotes(_100notesInAtm);
            System.out.println("Used " + _100notesInAtm + " notes of 100");
            balance = balance + (requiredNotes - _100notesInAtm) * 500;
        }

        if (balance != 0) {
            System.out.println("Something went wrong");
        }
    }
}
