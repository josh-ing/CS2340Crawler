package quack.models.items;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InventoryHUD {
    private Image inventory;
    private Image inventorySelect;

    public InventoryHUD() {
        try {
            inventory = new Image(new FileInputStream(
                    "src/main/resources/assets/inventory/inventory.png"));
            inventorySelect = new Image(new FileInputStream(
                    "src/main/resources/assets/inventory/inventorySelect.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Image getInventory() {
        return inventory;
    }

    public Image getInventorySelect() {
        return inventorySelect;
    }
}
