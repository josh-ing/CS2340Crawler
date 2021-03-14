package quack.models;

import quack.models.characters.PlayableCharacterModel;
import quack.models.weapons.WeaponModel;

public class PlayerModel {

    private String name;
    private int gold;
    private PlayableCharacterModel character;
    private WeaponModel weapon;
    private int currentHealth;
    private int currentMana;
    private int power;
    private int speed;
    private int x;
    private int y;

    public PlayerModel(String name, PlayableCharacterModel character, int gold) {
        this.name = name;
        this.character = character;
        this.currentHealth = character.getMaxHealth();
        this.currentMana = character.getMaxMana();
        this.power = character.getPower();
        this.speed = character.getSpeed();
        this.gold = gold;
    }

    public WeaponModel getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponModel weapon) {
        this.weapon = weapon;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
