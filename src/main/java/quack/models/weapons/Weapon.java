package quack.models.weapons;

/**
 * Class representing a weapon
 */
public class Weapon {

    private int rangeWidth;
    private int rangeLength;
    private int attack;
    private int speed;

    public Weapon(int rangeWidth, int rangeLength, int attack, int speed) {
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
}
