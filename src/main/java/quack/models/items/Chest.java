package quack.models.items;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Player;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.LongSwordWeapon;

import java.util.ArrayList;
import java.util.Random;

public class Chest extends GameObject {

    private Item item;
    private Random random = new Random();
    private boolean open = false;


    public Chest() {
        super("src/main/resources/assets/items/chest.png", 100);
        ItemTypes[] types = ItemTypes.values();
        ItemTypes randomType = types[random.nextInt(types.length)];

        switch (randomType) {
            case SUPER_POTION:
                item = new SuperPotion();
                break;
            case ATTACK_POTION:
                item = new AttackPotion();
                break;
            case HEALTH_POTION:
                item = new HealthPotion();
                break;
            case KNIFE:
                item = new KnifeWeapon();
                break;
            case SWORD:
                item = new LongSwordWeapon();
                break;
            default:
                item = new KatanaWeapon();
        }
    }

    @Override
    public void update() {
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();
        Player player = GameState.getInstance().getPlayer();

        if (!open) {
            for (KeyEvent keyEvent : inputs) {
                if (keyEvent.getCode() == KeyCode.C) {
                    if (player.getFacingPosition().equals(getPosition())) {
                        GameState.getInstance().getInventory().addItem(item);
                        open = true;
                    }
                }
            }
        }
    }

    public Item getItem() {
        return item;
    }

    public boolean isOpen() {
        return open;
    }
}
