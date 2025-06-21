package ATMLowLevelDesign.AmountWithDrawal;

import ATMLowLevelDesign.ATM;

public abstract class CashWithDrawProcessor {
    CashWithDrawProcessor nextCashWithdrawalProcessor;

    public CashWithDrawProcessor(CashWithDrawProcessor cashWithDrawProcessor) {
        this.nextCashWithdrawalProcessor = cashWithDrawProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
