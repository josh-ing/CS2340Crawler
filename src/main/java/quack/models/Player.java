package quack.models;

import javafx.scene.input.KeyEvent;
import quack.models.characters.Character;
import quack.models.weapons.Weapon;

import java.util.ArrayList;

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
        setRow(9);
        setCol(12);
    }

    public void update(long l) {
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        for (KeyEvent keyEvent: inputs) {
            if (keyEvent != null) {

                switch (keyEvent.getCode()) {
                    case LEFT:
                        if (currentRoom.isValidPosition(getRow(), getCol() - 1)) {
                            setCol(getCol() - 1);
                        }
                        break;

                    case RIGHT:
                        if (currentRoom.isValidPosition(getRow(), getCol() + 1)) {
                            setCol(getCol() + 1);
                        }
                        break;

                    case UP:
                        if (currentRoom.isValidPosition(getRow() - 1, getCol())) {
                            setRow(getRow() - 1);
                        }
                        break;

                    case DOWN:
                        if (currentRoom.isValidPosition(getRow() + 1, getCol())) {
                            setRow(getRow() + 1);
                        }
                        break;
                }

            }
        }


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
