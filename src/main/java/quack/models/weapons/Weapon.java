package quack.models.weapons;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class representing a weapon
 */
public class Weapon {

    private int rangeWidth;
    private int rangeLength;
    private int attack;
    private int speed;
    private Image spriteImage;

    public Weapon(int rangeWidth, int rangeLength, int attack, int speed, String sprite) {
        this.rangeWidth = rangeWidth;
        this.rangeLength = rangeLength;
        this.attack = attack;
        this.speed = speed;
        try {
            spriteImage = new Image(new FileInputStream(sprite));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
