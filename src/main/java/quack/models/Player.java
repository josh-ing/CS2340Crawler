package quack.models;

import javafx.scene.input.KeyEvent;
import quack.models.characters.Character;
import quack.models.monsters.Monster;
import quack.models.weapons.Weapon;

import java.util.ArrayList;

public class Player extends GameObject {

    private String name;
    private Character character;
    private Weapon weapon;
    private int gold;
    private int currHealth;

    public Player(String name, Character character, int gold) {
        super("src/main/resources/assets/characters/quackchar.png", 20000);
        this.name = name;
        this.character = character;
        this.currHealth = character.getMaxHealth();
        this.gold = gold;
        setPosition(new Position(9, 12));
    }

    public void update() {
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        for (KeyEvent keyEvent : inputs) {
            if (keyEvent != null) {

                switch (keyEvent.getCode()) {
                    case LEFT:
                        if (currentRoom.isValidPosition(getPosition().translateLeft())) {
                            setPosition(getPosition().translateLeft());
                        }
                        break;

                    case RIGHT:
                        if (currentRoom.isValidPosition(getPosition().translateRight())) {
                            setPosition(getPosition().translateRight());
                        }
                        break;

                    case UP:
                        if (currentRoom.isValidPosition(getPosition().translateUp())) {
                            setPosition(getPosition().translateUp());
                        }
                        break;

                    case DOWN:
                        if (currentRoom.isValidPosition(getPosition().translateDown())) {
                            setPosition(getPosition().translateDown());
                        }
                        break;
                }
            }
        }

        checkCellEvent();
    }

    public void checkCellEvent() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        Room.RoomCellType currentCellType = currentRoom.getMap()[getPosition().getRow()][getPosition().getCol()];
        Room nextRoom;
        Position nextPosition;

        switch (currentCellType) {
            case NORTH:
                nextRoom = currentRoom.getNeighbors()[0];
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.SOUTH).translateUp();
                break;

            case EAST:
                nextRoom = currentRoom.getNeighbors()[1];
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.WEST).translateRight();
                break;

            case SOUTH:
                nextRoom = currentRoom.getNeighbors()[2];
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.NORTH).translateDown();
                break;

            case WEST:
                nextRoom = currentRoom.getNeighbors()[3];
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.EAST).translateLeft();
                break;

            default:
                nextRoom = null;
                nextPosition = null;
        }

        if (nextRoom != null) {
            GameState.getInstance().setCurrentRoom(nextRoom);
            setPosition(nextPosition);
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

    public void attack() {
        Position attackPosition;
        if (getRotation() == Rotation.RIGHT) {
            attackPosition = getPosition().translateRight();
        } else if(getRotation() == Rotation.UP) {
            attackPosition = getPosition().translateUp();
        } else if(getRotation() == Rotation.LEFT) {
            attackPosition = getPosition().translateLeft();
        } else {
            attackPosition = getPosition().translateDown();
        }
        Monster monster = null;
        for (GameObject go: GameState.getInstance().getCurrentRoom().getGameObjects()) {
            if (go.getPosition() == attackPosition && go instanceof Monster) {
                monster = (Monster) go;
            }
        }
        if (monster != null) {
            monster.setHealth(monster.getHealth() - character.getAttack());
            if (monster.getHealth() <= 0) {
                GameState.getInstance().getCurrentRoom().getGameObjects().remove(monster);
            }
        }
    }
}
