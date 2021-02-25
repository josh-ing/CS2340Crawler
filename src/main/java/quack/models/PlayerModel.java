package quack.models;

import quack.models.characters.PlayableCharacterModel;
import quack.models.weapons.WeaponModel;

public class PlayerModel {

    private PlayableCharacterModel character;
    private WeaponModel weapon;
    private int currentHealth;
    private int currentMana;
    private int power;
    private int speed;

    public PlayerModel(PlayableCharacterModel character) {
        this.character = character;
        this.currentHealth = character.getMaxHealth();
        this.currentMana = character.getMaxMana();
        this.power = character.getPower();
        this.speed = character.getSpeed();
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
}
