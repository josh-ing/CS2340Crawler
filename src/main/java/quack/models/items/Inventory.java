package quack.models.items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    public static final int INVENTORY_SIZE = 5;

    public void addItem(Item item) {
        if (inventory.size() >= INVENTORY_SIZE) {
            inventory.remove(INVENTORY_SIZE - 1);
        }

        inventory.add(0, item);
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }
}
