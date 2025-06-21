package VendingMachine;

import VendingMachine.VendingStates.State;

public class Main {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelection(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] shelfs = vendingMachine.getInventoryObj().getInventoryShelf();
        for (int i = 0; i < shelfs.length; i++) {
            Item newItem = new Item();
            if (i < 3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            } else if (i < 5) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if (i < 7) {
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if (i < 10) {
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            shelfs[i].setItem(newItem);
            shelfs[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {

        ItemShelf[] shelves = vendingMachine.getInventoryObj().getInventoryShelf();
        for (int i = 0; i < shelves.length; i++) {
            System.out.println("CodeNumber: " + shelves[i].getCode() +
                    " Item: " + shelves[i].getItem().getItemType().name() +
                    " Price: " + shelves[i].getItem().getPrice() +
                    " isAvailable: " + !shelves[i].getSoldOut());
        }
    }
}
