package quack.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.PlayerModel;
import javafx.scene.text.*;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {

    /**
     * Initializes the controller with a stage.
     * @param stage
     */
    public GameController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show map.
     */
    public void initGame(Room room, PlayerModel player) {
        GameScreen gameScreen = new GameScreen(room);
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        this.stage.setScene(new Scene(gameScreen));
        gameScreen.getGoldText().setText("Gold: " + player.getGold());
    }
}
