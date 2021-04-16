import org.junit.jupiter.api.Test;
import quack.models.items.AttackPotion;
import quack.models.items.HealthPotion;
import quack.models.items.Inventory;
import quack.models.weapons.KatanaWeapon;

import static org.junit.Assert.assertEquals;
public class InventoryTest  {

    @Test
    public void inventoryNull() {
        Inventory test = new Inventory();
        assertEquals(true, test != null);
    }

    @Test
    public void checkSize() {
        AttackPotion test = new AttackPotion();
        HealthPotion test1 = new HealthPotion();
        Inventory sample = new Inventory();
        sample.addItem(test);
        sample.addItem(test1);
        assertEquals(2, sample.getItems().size());
    }

    @Test
   public void testAddToInventory() {
        Inventory test = new Inventory();
        KatanaWeapon katana = new KatanaWeapon();
        test.addItem(katana);
    }
}
