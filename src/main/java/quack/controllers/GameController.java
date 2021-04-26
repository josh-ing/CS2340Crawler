package quack.controllers;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.models.*;
import quack.models.Effects.Animations;
import quack.views.GameScreen;

import java.io.FileNotFoundException;
import java.util.ConcurrentModificationException;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private GameScreen gameScreen;
    private AnimationTimer gameLoop;
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
        Button getBackMenu = gameScreen.getBackMenu();
        getBackMenu.setFocusTraversable(false);
        getBackMenu.setOnAction(e -> {
            try {
                toMenuScreen();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        this.stage.setScene(new Scene(gameScreen));
        gameScreen.updateRoomGrid(GameState.getInstance().getCurrentRoom().getMap());

        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> processInput(key));

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateGameObjects(l);
                updateEffectObjects(l);
                checkPlayerDeath();
                checkWin();
                updateHUD();

                gameScreen.updateGameObjectGrid(GameState.getInstance().getCurrentRoom().
                        getGameObjects());
                gameScreen.updateEffectsGrid(GameState.getInstance().getEffectObjects());
                gameScreen.updateRoomGrid(GameState.getInstance().getCurrentRoom().getMap());
                gameScreen.updateEquipGrid();
                gameScreen.updateInventoryGrid();
                GameState.getInstance().clearInputs();
            }
        };

        gameLoop.start();
    }

    private void processInput(KeyEvent key) {
        GameState.getInstance().appendInput(key);
    }

    private void updateGameObjects(long l) {
        try {
            for (GameObject go: GameState.getInstance().getCurrentRoom().getGameObjects()) {
                go.update(l);
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    private void updateEffectObjects(long l) {
        try {
            for (Animations effects: GameState.getInstance().getEffectObjects()) {
                effects.update(l);
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    private void checkPlayerDeath() {
        if (GameState.getInstance().getPlayer().getCurrHealth() <= 0) {
            LoseScreenController loseScreenController = new LoseScreenController(stage);
            loseScreenController.initLose();
            gameLoop.stop();
        }
    }

    private void checkWin() {
        if (GameState.getInstance().getCurrentRoom().getRoomType() == Room.RoomType.EXIT) {
            WinScreenController winScreenController = new WinScreenController(stage);
            winScreenController.initWin();
            gameLoop.stop();
        }
    }

    private void updateHUD() {
        gameScreen.setHealth(GameState.getInstance().getPlayer().getCurrHealth());
        gameScreen.setGold(GameState.getInstance().getPlayer().getGold());
        gameScreen.setAttack(GameState.getInstance().getPlayer().getCurrAttack());
        gameScreen.updateInventoryGrid();
        gameScreen.updateEquipGrid();
    }
    /**
     * Goes back to the menu screen.
     * @throws FileNotFoundException if the file is not found.
     */
    public void toMenuScreen() throws FileNotFoundException {
        MainMenuController mainMenu = new MainMenuController(stage);
        mainMenu.initMainMenu();
    }
}
