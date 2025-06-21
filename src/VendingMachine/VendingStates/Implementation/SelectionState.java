package VendingMachine.VendingStates.Implementation;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;


import java.util.List;

public class SelectionState implements State {
    @Override
    public void clickOnStartProductSelection(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the exchange money");
        return returnChangeMoney;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventoryObj().getItem(codeNumber);

        int paidByUser = 0;
        for (Coin coin : vendingMachine.getCoinList()) {
            paidByUser += coin.value;
        }

        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("insufficient amount");
        } else {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("returned full amount");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you cannot click on insert button selection state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("you cannot update inventory in selection state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in selection state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you cannot insert coin in product selection state");

    }


}
