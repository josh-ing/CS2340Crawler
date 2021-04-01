package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.Player;
import quack.models.RoomGenerator;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private RoomGenerator roomGenerator;
    private GameScreen gameScreen;
    private Room currentRoom;
    private Player player;
    private KeyEvent currentAction;

    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the game controller.
     */
    public GameController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show map.
     * @param roomGenerator The randomly generated map.
     * @param player The player model chosen.
     */
    public void initGame(RoomGenerator roomGenerator, Player player) {
        this.roomGenerator = roomGenerator;
        this.player = player;

        Room start = roomGenerator.generateStartRoom();
        this.currentRoom = start;

        gameScreen = new GameScreen();
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        //gameScreen.getGoldText().setText("Gold: " + player.getGold());

        this.stage.setScene(new Scene(gameScreen));
        gameScreen.updateRoomGrid(currentRoom.getMap());

        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> processInput(key));
    }

    private void setGameScreenRoom(Room room) {
        if (room.getRoomType() == Room.RoomType.EXIT) {
            WinScreenController winScreenController = new WinScreenController(stage);
            winScreenController.initWin();
        } else {
            this.currentRoom = room;
            gameScreen.updateRoomGrid(currentRoom.getMap());
            gameScreen.getGoldText().setText("Gold: " + player.getGold());
        }
    }

    private void processInput(KeyEvent key) {
        this.currentAction = key;
        update();
        gameScreen.updateRoomGrid(currentRoom.getMap());
    }

    private void update() {
        if (this.currentAction != null) {

            System.out.println(this.currentAction);

            switch (this.currentAction.getCode()) {
                case UP:
                    if (isValidPosition(player.getX(), player.getY() - 1)) {
                        player.setY(player.getY() - 1);
                    }
                    break;

                case DOWN:
                    if (isValidPosition(player.getX(), player.getY() + 1)) {
                        player.setY(player.getY() + 1);
                    }
                    break;

                case LEFT:
                    if (isValidPosition(player.getX() - 1, player.getY())) {
                        player.setX(player.getX() - 1);
                    }
                    break;

                case RIGHT:
                    if (isValidPosition(player.getX() + 1, player.getY())) {
                        player.setX(player.getX() + 1);
                    }
                    break;
            }

            this.currentAction = null;

        }
    }

    private boolean isValidPosition(int x, int y) {
        return (currentRoom.getMap()[y][x] != Room.RoomCellType.WALL);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
