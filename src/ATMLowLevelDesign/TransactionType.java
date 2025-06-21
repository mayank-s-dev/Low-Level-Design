package ATMLowLevelDesign;

public enum TransactionType {

    CASH_WITHDRAW,
    BALANCE_CHECK;

    public static void showAllOperations() {
        System.out.println("These are the available operations");
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println(transactionType.name());
        }
    }
}
