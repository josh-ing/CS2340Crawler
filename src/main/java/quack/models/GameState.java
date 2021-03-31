package quack.models;

public class GameState {
    private static GameState gameState = null;

    private Player player;
    private Room currentRoom;

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
}
