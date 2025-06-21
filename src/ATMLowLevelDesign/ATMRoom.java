package ATMLowLevelDesign;

import java.util.Date;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentAtmStatus();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.user.card, 1111);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAW);
        atmRoom.atm.getAtmState().cashWithdraw(atmRoom.atm, atmRoom.user.card, 8900);
    }

    public void initialize() {
        this.user = createUser();
        this.atm = ATM.getAtmObj();
        this.atm.setAtmBalanceAndNotes(25, 80, 100);
    }

    private User createUser() {
        User user = new User();
        Card card = createCard();
        user.setCard(card);
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setCardNo("1662272727272727");
        card.setCvvNo(888);
        card.setExpiryDate(new Date(19 / 10 / 2025));
        card.setUserBankAccount(new UserBankAccount(10000));
        card.setPin(1111);

        return card;
    }
}
