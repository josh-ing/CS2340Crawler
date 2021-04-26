package quack.models;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import quack.models.Effects.KatanaAnim;
import quack.models.Effects.KnifeAnim;
import quack.models.Effects.SwordAnim;
import quack.models.characters.Character;
import quack.models.items.DroppedItem;
import quack.models.items.Item;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.LongSwordWeapon;
import quack.models.weapons.Weapon;

import java.util.ArrayList;

public class Player extends GameObject implements Attacker, Attackable {

    private String name;
    private Character character;
    private Weapon weapon;
    private int gold;
    private int currHealth;
    private int currAttack;
    private KatanaAnim katana = new KatanaAnim();
    private KnifeAnim knife = new KnifeAnim();
    private SwordAnim sword = new SwordAnim();

    public Player(String name, Character character, Weapon weapon, int gold) {
        super("src/main/resources/assets/quack.gif",
                10000000 / character.getSpeed());
        this.name = name;
        this.character = character;
        this.currHealth = character.getMaxHealth();
        this.gold = gold;
        this.weapon = weapon;
        this.currAttack = character.getAttack();
        setPosition(new Position(9, 12));
    }

    public void update() {
        checkPlayerMovement();
        checkPlayerAttack();
        checkInventory();
        checkCellEvent();
        checkDroppedItems();
    }

    public void checkInventory() {
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();
        ArrayList<Item> inventory = GameState.getInstance().getInventory().getItems();

        for (KeyEvent keyEvent : inputs) {
            switch (keyEvent.getCode()) {
            case DIGIT1:
                if (inventory.size() > 0) {
                    inventory.get(0).use();
                }
                break;
            case DIGIT2:
                if (inventory.size() > 1) {
                    inventory.get(1).use();
                }
                break;
            case DIGIT3:
                if (inventory.size() > 2) {
                    inventory.get(2).use();
                }
                break;
            case DIGIT4:
                if (inventory.size() > 3) {
                    inventory.get(3).use();
                }
                break;
            case DIGIT5:
                if (inventory.size() > 4) {
                    inventory.get(4).use();
                }
                break;
            default:
                break;
            }
        }
    }

    public Position getFacingPosition() {
        Position facingPosition;

        if (getRotation() == Rotation.RIGHT) {
            facingPosition = getPosition().translateRight();
        } else if (getRotation() == Rotation.UP) {
            facingPosition = getPosition().translateUp();
        } else if (getRotation() == Rotation.LEFT) {
            facingPosition = getPosition().translateLeft();
        } else {
            facingPosition = getPosition().translateDown();
        }

        return facingPosition;
    }

    public void checkPlayerAttack() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        ArrayList<KeyEvent> inputs = GameState.getInstance().getCurrentInputs();



        for (KeyEvent keyEvent : inputs) {
            if (keyEvent.getCode() == KeyCode.SPACE) {
                if (weapon instanceof KatanaWeapon) {
                    GameState.getInstance().getEffectObjects().add(katana);
                    katana.setPosition(this.getFacingPosition());
                    katana.setRotation(this.getRotation());
                } else if (weapon instanceof KnifeWeapon) {
                    GameState.getInstance().getEffectObjects().add(knife);
                    knife.setPosition(this.getFacingPosition());
                    knife.setRotation(this.getRotation());
                } else if (weapon instanceof LongSwordWeapon) {
                    GameState.getInstance().getEffectObjects().add(sword);
                    sword.setPosition(this.getFacingPosition());
                    sword.setRotation(this.getRotation());
                }

                GameObject gameObjectAtPosition = currentRoom.getGameObjectAtPosition(
                        getFacingPosition());

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

    public void checkDroppedItems() {
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        for (GameObject o : currentRoom.getGameObjects()) {
            if (o instanceof DroppedItem && this.getPosition().equals(o.getPosition())) {
                DroppedItem dropItem = (DroppedItem) o;
                GameState.getInstance().getInventory().addItem(dropItem.getItem());
                currentRoom.getGameObjects().remove(o);
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
            boolean isChallengeDone = currentRoom.getRoomType() != Room.RoomType.CHALLENGE || currentRoom.isEmptyOfMonsters();
            if (isChallengeDone && (GameState.getInstance().getVisitedRooms()
                    .contains(nextRoom) || currentRoom.isEmptyOfMonsters())) {
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
            target.damage(currAttack + weapon.getAttack());
            GameState.getInstance().incrementDamageDealt(currAttack + weapon.getAttack());
        }
    }

    public void setCurrAttack(int currAttack) {
        this.currAttack = currAttack;
    }

    public int getCurrAttack() {
        return currAttack;
    }
}
