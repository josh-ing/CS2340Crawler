package quack.models.weapons;
import quack.models.GameState;
import quack.models.items.Item;

/**
 * Class representing a weapon
 */
public class Weapon extends Item {

    private int rangeWidth;
    private int rangeLength;
    private int attack;
    private int speed;

    public Weapon(int rangeWidth, int rangeLength, int attack, int speed, String sprite) {
        super(sprite);
        this.rangeWidth = rangeWidth;
        this.rangeLength = rangeLength;
        this.attack = attack;
        this.speed = speed;
    }

    public int getRangeWidth() {
        return rangeWidth;
    }

    public int getRangeLength() {
        return rangeLength;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void use() {
        GameState.getInstance().getPlayer().setWeapon(this);
        GameState.getInstance().getInventory().getItems().remove(this);
    }

    @Override
    public void unUse() {

    }
}
