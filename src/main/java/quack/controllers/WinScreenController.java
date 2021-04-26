package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.WinScreen;

import java.io.FileNotFoundException;


public class WinScreenController extends Controller {
    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the Win Screen controller.
     */
    public WinScreenController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show Win Screen.
     * @throws FileNotFoundException if the file is not found.
     */
    public void initWin() {
        WinScreen winScreen = new WinScreen();
        winScreen.setMinWidth(1200);
        winScreen.setMinHeight(900);
        winScreen.setFocusTraversable(false);

        this.stage.setScene(new Scene(winScreen));
        Button newGameButton = winScreen.getMenuButton();
        newGameButton.setOnAction(e -> {
            try {
                toMenuScreen();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        stage.show();
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
