package quack.models.items;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Item {
    private int healthRegen;
    private int attackInc;
    private int rangeLInc;
    private int rangeWInc;
    private Image spriteImage;

    public Item(int healthRegen, int attackInc, int rangeLInc, int rangeWInc, String sprite) {
        this.healthRegen = healthRegen;
        this.attackInc = attackInc;
        this.rangeLInc = rangeLInc;
        this.rangeWInc = rangeWInc;
        try {
            spriteImage = new Image(new FileInputStream(sprite));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int getAttackInc() {
        return attackInc;
    }

    public int getRangeLInc() {
        return rangeLInc;
    }

    public int getRangeWInc() {
        return rangeWInc;
    }
}
