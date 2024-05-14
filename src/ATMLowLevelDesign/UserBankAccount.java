package ATMLowLevelDesign;

public class UserBankAccount {
    int bankBalance;

    public UserBankAccount(int amount) {
        this.bankBalance = amount;
    }

    public int updateBalance(int withdrawBalance) {
        int currBalance = this.bankBalance;
        int newBalance = currBalance - withdrawBalance;
        this.bankBalance = newBalance;
        return newBalance;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

}
