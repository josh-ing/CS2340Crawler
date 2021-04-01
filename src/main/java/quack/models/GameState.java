package quack.models;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class GameState {
    private static GameState gameState = null;

    private Player player;
    private Room currentRoom;
    private ArrayList<KeyEvent> currentInputs = new ArrayList<>();

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
    }
}
