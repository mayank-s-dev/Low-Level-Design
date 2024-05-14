package VendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeItemInventory();
    }

    public ItemShelf[] getInventoryShelf() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initializeItemInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf shelfItem = new ItemShelf();
            shelfItem.setCode(startCode);
            shelfItem.setSoldOut(false);
            inventory[i] = shelfItem;
            startCode++;
        }
    }

    public void addItem(int code, Item item) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == code) {
                if (itemShelf.getSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(true);
                } else {
                    throw new Exception("Item is already present");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.getSoldOut()) {
                    throw new Exception("item already sold out");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
