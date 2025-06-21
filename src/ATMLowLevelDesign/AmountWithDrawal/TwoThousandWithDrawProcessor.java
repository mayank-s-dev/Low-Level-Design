package ATMLowLevelDesign.AmountWithDrawal;

import ATMLowLevelDesign.ATM;

public class TwoThousandWithDrawProcessor extends CashWithDrawProcessor {
    public TwoThousandWithDrawProcessor(CashWithDrawProcessor cashWithDrawProcessor) {
        super(cashWithDrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {

        int requiredNotes = remainingAmount / 2000;
        int balance = remainingAmount % 2000;
        int _2000notesInAtm = atm.getNoOf2kNotes();

        if (requiredNotes <= _2000notesInAtm) {
            atm.deductTwoThousandNotes(requiredNotes);
            System.out.println("Used " + requiredNotes + " notes of 2000");
        } else if (requiredNotes > atm.getNoOf2kNotes()) {
            atm.deductTwoThousandNotes(_2000notesInAtm);
            balance = balance + (requiredNotes - _2000notesInAtm) * 2000;
            System.out.println("Used " + requiredNotes + " notes of 2000");
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
