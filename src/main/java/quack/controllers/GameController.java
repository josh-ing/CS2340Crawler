package quack.controllers;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.PlayerModel;
import quack.models.RoomGenerator;

import java.util.Arrays;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private RoomGenerator roomGenerator;
    private GameScreen gameScreen;
    private Room currentRoom;
    private PlayerModel player;

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
    public void initGame(RoomGenerator roomGenerator, PlayerModel player) {
        this.roomGenerator = roomGenerator;
        this.player = player;

        Room start = roomGenerator.generateStartRoom();
        this.currentRoom = start;

        gameScreen = new GameScreen(start, player);
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        gameScreen.getGoldText().setText("Gold: " + player.getGold());

        this.stage.setScene(new Scene(gameScreen));
        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> changeRoom(key));
    }

    private void setGameScreenRoom(Room room) {
        if (room.getRoomType() == Room.RoomType.EXIT) {
            WinScreenController winScreenController = new WinScreenController(stage);
            winScreenController.initWin();
        } else {
            this.currentRoom = room;
            gameScreen.setRoom(room);
            gameScreen.getGoldText().setText("Gold: " + player.getGold());
        }
    }

    public void changeRoom(KeyEvent key) {
        Room[] neighbors = currentRoom.getNeighbors();
        System.out.println(Arrays.toString(neighbors));

        switch (key.getCode()) {
        case UP:
            if (neighbors[0] != null) {
                setGameScreenRoom(neighbors[0]);
            }
            break;

        case RIGHT:
            if (neighbors[1] != null) {
                setGameScreenRoom(neighbors[1]);
            }
            break;

        case DOWN:
            if (neighbors[2] != null) {
                setGameScreenRoom(neighbors[2]);
            }
            break;

        case LEFT:
            if (neighbors[3] != null) {
                setGameScreenRoom(neighbors[3]);
            }
            break;

        default:
            break;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
