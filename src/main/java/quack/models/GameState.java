package quack.models;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class GameState {
    private static GameState gameState = null;

    private Player player;
    private Room currentRoom;
    private ArrayList<KeyEvent> currentInputs;

    private GameState() {
        RoomGenerator roomGenerator = new RoomGenerator(7, 24, 18);
        currentRoom = roomGenerator.generateStartRoom();
    }

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
        }

        return gameState;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
