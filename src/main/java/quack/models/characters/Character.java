package quack.models.characters;

import javafx.scene.image.Image;
import quack.models.GameObject;

public abstract class Character {

    private int maxHealth;
    private int attack;
    private int speed;
    private Image spriteAsset;

    public Character(int maxHealth, int attack, int speed, String sprite) {
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.speed = speed;
        // Load image
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getSpriteAsset() {
        return spriteAsset;
    }
}