package quack.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.QuackApp;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;

import java.io.FileNotFoundException;

/**
 * Controller for MainMenuScreen
 */
public class MainMenuController extends Controller {

    /**
     * Initializes the controller with a stage.
     * @param stage
     */
    public MainMenuController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show main menu.
     */

    public void initMainMenu() throws FileNotFoundException {
        stage.setWidth(1200);
        stage.setHeight(900);

        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        this.stage.setScene(new Scene(mainMenuScreen));
        Button newGameButton = mainMenuScreen.getNewGameButton();
        newGameButton.setOnAction(e -> {
            try {
                toConfigScreen();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        stage.show();
    }

    /**
     * Goes to the config screen.
     */
    public void toConfigScreen() throws FileNotFoundException {
        ConfigController configControl = new ConfigController(stage);
        configControl.initConfig();
    }
}
