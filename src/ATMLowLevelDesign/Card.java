package ATMLowLevelDesign;

import java.util.Date;

public class Card {
    String cardNo;
    int cvvNo;
    Date expiryDate;

    String cardHolderName;

    int pin;
    UserBankAccount userBankAccount;

    public boolean verifyPin(int input_pin) {
        return this.pin == input_pin;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getCvvNo() {
        return cvvNo;
    }

    public void setCvvNo(int cvvNo) {
        this.cvvNo = cvvNo;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void deductUserBalance(int withdrawAmount) {
        UserBankAccount userBankAccount = this.getUserBankAccount();
        int userBalance = userBankAccount.getBankBalance();
        int newBalance = userBalance - withdrawAmount;
        userBankAccount.setBankBalance(newBalance);

    }
}
