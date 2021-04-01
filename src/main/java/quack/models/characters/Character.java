package quack.models.characters;

import quack.models.GameObject;

public class Character {

    private int maxHealth;
    private int attack;
    private int speed;

    public Character(int maxHealth, int attack, int speed) {
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.speed = speed;
    }

    public void update() {

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

}