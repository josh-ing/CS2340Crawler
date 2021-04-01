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
       // if (this.currentAction != null) {
//
//            System.out.println(this.currentAction);
//
//            switch (this.currentAction.getCode()) {
//                case UP:
//                    if (isValidPosition(player.getX(), player.getY() - 1)) {
//                        player.setY(player.getY() - 1);
//                    }
//                    break;
//
//                case DOWN:
//                    if (isValidPosition(player.getX(), player.getY() + 1)) {
//                        player.setY(player.getY() + 1);
//                    }
//                    break;
//
//                case LEFT:
//                    if (isValidPosition(player.getX() - 1, player.getY())) {
//                        player.setX(player.getX() - 1);
//                    }
//                    break;
//
//                case RIGHT:
//                    if (isValidPosition(player.getX() + 1, player.getY())) {
//                        player.setX(player.getX() + 1);
//                    }
//                    break;
//            }
//
//            this.currentAction = null;
//
//        }
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
