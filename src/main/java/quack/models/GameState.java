package quack.models;

import javafx.scene.input.KeyEvent;
import quack.models.Effects.Animations;
import quack.models.items.Inventory;
import quack.models.items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    private static GameState gameState = null;

    private Player player;
    private Room currentRoom;
    private ArrayList<Animations> effectArray = new ArrayList<>();
    private Set<Room> visitedRooms = new HashSet<>();
    private ArrayList<KeyEvent> currentInputs = new ArrayList<>();
    private Inventory inventory = new Inventory();
    private Item usedItem;
    private int monstersKilled;
    private int damageDealt;


    private GameState() {
        RoomGenerator roomGenerator = new RoomGenerator(7, 24, 18);
        setCurrentRoom(roomGenerator.generateStartRoom());
    }

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
        }

        return gameState;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.currentRoom.addGameObject(player);
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void incrementMonstersKilled(int increment) {
        monstersKilled = monstersKilled + increment;
    }

    public void incrementDamageDealt(int damage) {
        damageDealt = damageDealt + damage;
    }

    public static void reset() {
        gameState = null;
    }

    public void appendInput(KeyEvent input) {
        currentInputs.add(input);
    }

    public ArrayList<KeyEvent> getCurrentInputs() {
        return currentInputs;
    }

    public void clearInputs() {
        currentInputs = new ArrayList<KeyEvent>();
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        if (player != null) {
            this.currentRoom.getGameObjects().remove(player);
            this.currentRoom = currentRoom;
            this.currentRoom.addGameObject(player);
        } else {
            this.currentRoom = currentRoom;
        }

        visitedRooms.add(currentRoom);
    }

    public Set<Room> getVisitedRooms() {
        return visitedRooms;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setUsedItem(Item item) {
        if (usedItem != null) {
            usedItem.unUse();
        }

        usedItem = item;
    }

    public Item getUsedItem() {
        return usedItem;
    }

    public ArrayList<Animations> getEffectObjects() { return effectArray; }
}
