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
        Button instructPageButton = mainMenuScreen.getInstructPageButton();
        newGameButton.setOnAction(e -> {
            try {
                toConfigScreen();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        });
        instructPageButton.setOnAction(e -> {
                try {
                    toInstructScreen();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });
        stage.show();
    }

    /**
     * Initializes app to show win screen. Just for testing
     * @throws FileNotFoundException if the file is not found.
     */
    public void initWinMenu() throws FileNotFoundException {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        mainMenuScreen.setMinWidth(1200);
        mainMenuScreen.setMinHeight(900);
        this.stage.setScene(new Scene(mainMenuScreen));
        Button newGameButton = mainMenuScreen.getNewGameButton();
        newGameButton.setOnAction(e -> {
            try {
                toWinScreen();
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

    /**
     * Goes to the instruction screen.
     * @throws FileNotFoundException if the file is not found.
     */
    public void toInstructScreen() throws FileNotFoundException {
        InstructScreenController toInstructScreen = new InstructScreenController(stage);
        toInstructScreen.initInstructScreen();
    }

    /**
     * Goes to the win screen. Just for testing
     * @throws FileNotFoundException if the file is not found.
     */
    public void toWinScreen() throws FileNotFoundException {
        WinScreenController winScreen = new WinScreenController(stage);
        winScreen.initWin();
    }
}
