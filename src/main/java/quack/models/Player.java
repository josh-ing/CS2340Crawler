package quack.models;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import quack.models.characters.Character;
import quack.models.weapons.Weapon;

import java.util.ArrayList;

public class Player extends GameObject implements Attacker, Attackable {

    private String name;
    private Character character;
    private Weapon weapon;
    private int gold;
    private int currHealth;

    public Player(String name, Character character, Weapon weapon, int gold) {
        super("src/main/resources/assets/characters/quackchar.png",
                10000000 / character.getSpeed());
        this.name = name;
        this.character = character;
        this.currHealth = character.getMaxHealth();
        this.gold = gold;
        this.weapon = weapon;
        setPosition(new Position(9, 12));
    }

    public void update() {
        checkPlayerMovement();
        checkPlayerAttack();
        checkCellEvent();
    }

    public void checkPlayerAttack() {
        Position attackPosition;
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();

        for (KeyEvent keyEvent : inputs) {
            if (keyEvent.getCode() == KeyCode.SPACE) {
                if (getRotation() == Rotation.RIGHT) {
                    attackPosition = getPosition().translateRight();
                } else if (getRotation() == Rotation.UP) {
                    attackPosition = getPosition().translateUp();
                } else if (getRotation() == Rotation.LEFT) {
                    attackPosition = getPosition().translateLeft();
                } else {
                    attackPosition = getPosition().translateDown();
                }

                GameObject gameObjectAtPosition = currentRoom.getGameObjectAtPosition(
                        attackPosition);

                if (gameObjectAtPosition instanceof Attackable) {
                    Attackable attackable = (Attackable) gameObjectAtPosition;

                    attack(attackable);
                }
            }
        }
    }

    public void checkPlayerMovement() {
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        for (KeyEvent keyEvent : inputs) {
            if (keyEvent != null) {

                switch (keyEvent.getCode()) {
                case LEFT:
                    setRotation(Rotation.LEFT);
                    if (currentRoom.isValidPosition(getPosition().translateLeft())) {
                        setPosition(getPosition().translateLeft());
                    }
                    break;

                case RIGHT:
                    setRotation(Rotation.RIGHT);
                    if (currentRoom.isValidPosition(getPosition().translateRight())) {
                        setPosition(getPosition().translateRight());
                    }
                    break;

                case UP:
                    setRotation(Rotation.UP);
                    if (currentRoom.isValidPosition(getPosition().translateUp())) {
                        setPosition(getPosition().translateUp());
                    }
                    break;

                case DOWN:
                    setRotation(Rotation.DOWN);
                    if (currentRoom.isValidPosition(getPosition().translateDown())) {
                        setPosition(getPosition().translateDown());
                    }
                    break;
                default:
                    break;
                }
            }
        }
    }

    public void checkCellEvent() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        Room.RoomCellType currentCellType = currentRoom.getMap()[getPosition()
                .getRow()][getPosition().getCol()];
        Room nextRoom;
        Position nextPosition = new Position(0, 0);

        switch (currentCellType) {
        case NORTH:
            nextRoom = currentRoom.getNeighbors()[0];
            if (nextRoom.getRoomType() != Room.RoomType.EXIT) {
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.SOUTH).translateUp();
            }
            break;

        case EAST:
            nextRoom = currentRoom.getNeighbors()[1];
            if (nextRoom.getRoomType() != Room.RoomType.EXIT) {
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.WEST).translateRight();
            }
            break;

        case SOUTH:
            nextRoom = currentRoom.getNeighbors()[2];
            if (nextRoom.getRoomType() != Room.RoomType.EXIT) {
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.NORTH).translateDown();
            }
            break;

        case WEST:
            nextRoom = currentRoom.getNeighbors()[3];
            if (nextRoom.getRoomType() != Room.RoomType.EXIT) {
                nextPosition = nextRoom.getExitPosition(Room.RoomCellType.EAST).translateLeft();
            }
            break;

        default:
            nextRoom = null;
        }

        if (nextRoom != null) {
            if (GameState.getInstance().getVisitedRooms()
                    .contains(nextRoom) || currentRoom.isEmptyOfMonsters()) {
                GameState.getInstance().setCurrentRoom(nextRoom);
                setPosition(nextPosition);
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

    @Override
    public void damage(int damage) {
        setCurrHealth(getCurrHealth() - damage);
    }

    @Override
    public void attack(Attackable target) {
        if (target != null) {
            target.damage(character.getAttack() + weapon.getAttack());
        }
    }
}