package quack.models;

import quack.models.characters.Character;
import quack.models.weapons.Weapon;

public class Player extends GameObject {

    private String name;
    private Character character;
    private Weapon weapon;
    private int gold;
    private int currHealth;

    public Player(String name, Character character, int gold) {
        this.name = name;
        this.character = character;
        this.currHealth = character.getMaxHealth();
        this.gold = gold;
    }

    public void update() {

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
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
}
