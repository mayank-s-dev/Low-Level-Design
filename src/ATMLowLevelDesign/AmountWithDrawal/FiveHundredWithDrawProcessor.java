package ATMLowLevelDesign.AmountWithDrawal;

import ATMLowLevelDesign.ATM;

public class FiveHundredWithDrawProcessor extends CashWithDrawProcessor {
    public FiveHundredWithDrawProcessor(CashWithDrawProcessor cashWithDrawProcessor) {
        super(cashWithDrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 500;
        int balance = remainingAmount % 500;
        int _500notesInAtm = atm.getNoOfFiveHundredNotes();

        if (requiredNotes <= _500notesInAtm) {
            System.out.println("Used " + requiredNotes + " notes of 500");
            atm.deductFiveHundredNotes(requiredNotes);
        } else {
            atm.deductFiveHundredNotes(_500notesInAtm);
            System.out.println("Used " + _500notesInAtm + " notes of 500");
            balance = balance + (requiredNotes - _500notesInAtm) * 500;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
