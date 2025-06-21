package VendingMachine.VendingStates.Implementation;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;


import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Currently vending machine is in HasMoney State");
    }

    @Override
    public void clickOnStartProductSelection(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("returned full amount");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in hasMoney state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("you cannot update inventory in has money state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in has money state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You need to click on start product selection button first");
    }
}
