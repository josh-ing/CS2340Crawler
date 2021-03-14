package quack.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.MainMenuScreen;

import java.io.FileNotFoundException;

/**
 * Controller for MainMenuScreen
 */
public class MainMenuController extends Controller {

    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the main menu controller.
     */
    public MainMenuController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show main menu.
     * @throws FileNotFoundException if the file is not found.
     */

    public void initMainMenu() throws FileNotFoundException {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        mainMenuScreen.setMinWidth(1200);
        mainMenuScreen.setMinHeight(900);
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
     * @throws FileNotFoundException if the file is not found.
     */
    public void toConfigScreen() throws FileNotFoundException {
        ConfigController configControl = new ConfigController(stage);
        configControl.initConfig();
    }
}
