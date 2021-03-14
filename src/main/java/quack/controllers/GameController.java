package quack.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.PlayerModel;
import quack.models.RoomGenerator;
import java.awt.event.KeyEvent;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private RoomGenerator gameLayout;
    GameScreen gameScreen;
    private Room current;
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
        gameLayout = roomGenerator;
        this.player = player;
        gameScreen = new GameScreen(gameLayout.generateStartRoom(), player);
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        this.stage.setScene(new Scene(gameScreen));
        gameScreen.getGoldText().setText("Gold: " + player.getGold());
    }

    public void changeRoom(KeyEvent e, Room room) {
        Room[] values = room.getNeighbors();
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (values[0] != null) {
                    gameScreen = new GameScreen(values[0], player);
                    this.stage.setScene(new Scene(gameScreen));
                } else if (values[0].getRoomType() == Room.RoomType.EXIT) {
                    //victory screen
                }
                break;

            case KeyEvent.VK_RIGHT:
                if (values[1] != null) {
                    gameScreen = new GameScreen(values[1], player);
                    this.stage.setScene(new Scene(gameScreen));
                } else if (values[1].getRoomType() == Room.RoomType.EXIT) {
                    //victory screen
                }
                break;

            case KeyEvent.VK_DOWN:
                if (values[2] != null) {
                    gameScreen = new GameScreen(values[2], player);
                } else if (values[2].getRoomType() == Room.RoomType.BOSS) {
                    //victory screen
                }
                break;

            case KeyEvent.VK_LEFT:
                if (values[3] != null) {
                    gameScreen = new GameScreen(values[3], player);
                } else if (values[3].getRoomType() == Room.RoomType.BOSS) {
                    //victory screen
                }
                break;
        }
    }
}
