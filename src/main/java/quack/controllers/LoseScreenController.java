package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.LoseScreen;

import java.io.FileNotFoundException;


public class LoseScreenController extends Controller {
    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the Win Screen controller.
     */
    public LoseScreenController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show Win Screen.
     * @throws FileNotFoundException if the file is not found.
     */
    public void initLose() {
        LoseScreen loseScreen = new LoseScreen();
        loseScreen.setMinWidth(1200);
        loseScreen.setMinHeight(900);
        this.stage.setScene(new Scene(loseScreen));
        Button newGameButton = loseScreen.getMenuButton();
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
