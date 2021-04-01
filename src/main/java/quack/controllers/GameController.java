package quack.controllers;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.models.*;
import quack.views.GameScreen;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
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
     */
    public void initGame() {
        gameScreen = new GameScreen();
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        //gameScreen.getGoldText().setText("Gold: " + player.getGold());

        this.stage.setScene(new Scene(gameScreen));
        gameScreen.updateRoomGrid(GameState.getInstance().getCurrentRoom().getMap());

        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> processInput(key));

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateGameObjects(l);

                gameScreen.updateGameObjectGrid(GameState.getInstance().getCurrentRoom().getGameObjects());
                gameScreen.updateRoomGrid(GameState.getInstance().getCurrentRoom().getMap());

                GameState.getInstance().clearInputs();
            }
        };

        gameLoop.start();
    }

    private void processInput(KeyEvent key) {
        GameState.getInstance().appendInput(key);
    }

    private void updateGameObjects(long l) {
        for (GameObject go: GameState.getInstance().getCurrentRoom().getGameObjects()) {
            go.update(l);
        }
    }
}
