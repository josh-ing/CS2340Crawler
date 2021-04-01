package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.models.GameState;
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
    public void initGame() {
        gameScreen = new GameScreen();
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        //gameScreen.getGoldText().setText("Gold: " + player.getGold());

        this.stage.setScene(new Scene(gameScreen));
        gameScreen.updateRoomGrid(GameState.getInstance().getCurrentRoom().getMap());

        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> processInput(key));


    }

    private void processInput(KeyEvent key) {
        GameState.getInstance().appendInput(key);
    }

    private void updateGameObjects() {

    }
}
