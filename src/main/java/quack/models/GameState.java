package quack.models;

import javafx.scene.input.KeyEvent;
import quack.models.items.Inventory;
import quack.models.items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    private static GameState gameState = null;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Player player;
    private Room currentRoom;
    private Set<Room> visitedRooms = new HashSet<>();
    private ArrayList<KeyEvent> currentInputs = new ArrayList<>();
<<<<<<< HEAD
=======
    private Inventory inventory = new Inventory();
    private Item usedItem;
>>>>>>> 67d8f8d0a1272678384d94a883d168cf4fc24832

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

<<<<<<< HEAD
=======
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
>>>>>>> 67d8f8d0a1272678384d94a883d168cf4fc24832
}
