package quack.controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.PlayerModel;
import quack.models.Map;
import java.awt.event.KeyListener;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private Map gameLayout;
    GameScreen gameScreen;
    private Room current;

    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the game controller.
     */
    public GameController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show map.
     * @param map The randomly generated map.
     * @param player The player model chosen.
     */
    public void initGame(Map map, PlayerModel player) {
        Room starter = map.generateMap();
        gameScreen = new GameScreen(starter);
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        this.stage.setScene(new Scene(gameScreen));
        gameScreen.getGoldText().setText("Gold: " + player.getGold());
        this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> changeRoom(e, starter));

    }

    public void changeRoom(KeyEvent e, Room room) {
        Room[] values = room.getNeighbors();
        switch(e.getCode()) {
            case UP:
                if (values[0] != null) {
                    gameScreen = new GameScreen(values[0]);
                    gameScreen.setMinWidth(1200);
                    gameScreen.setMinHeight(900);
                    this.stage.setScene(new Scene(gameScreen));
                    this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, k -> changeRoom(e, values[0]));
                }
                break;

            case RIGHT:
                if (values[1] != null) {
                    gameScreen = new GameScreen(values[1]);
                    gameScreen.setMinWidth(1200);
                    gameScreen.setMinHeight(900);
                    this.stage.setScene(new Scene(gameScreen));
                    this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, k -> changeRoom(e, values[1]));
                }
                break;

            case DOWN:
                if (values[2] != null) {
                    gameScreen = new GameScreen(values[2]);
                    gameScreen.setMinWidth(1200);
                    gameScreen.setMinHeight(900);
                    this.stage.setScene(new Scene(gameScreen));
                    this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, k -> changeRoom(e, values[2]));
                }
                break;

            case LEFT:
                if (values[3] != null) {
                    gameScreen = new GameScreen(values[3]);
                    gameScreen.setMinWidth(1200);
                    gameScreen.setMinHeight(900);
                    this.stage.setScene(new Scene(gameScreen));
                    this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, k -> changeRoom(e, values[3]));
                }
                break;
        }
    }
}
