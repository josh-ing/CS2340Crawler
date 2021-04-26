package quack.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.InstructScreen;

import java.io.FileNotFoundException;

public class InstructScreenController extends Controller {
    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the main menu controller.
     */
    public InstructScreenController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show main menu.
     * @throws FileNotFoundException if the file is not found.
     */
    public void initInstructScreen() throws FileNotFoundException {
        InstructScreen instructScreen = new InstructScreen();
        instructScreen.setMinWidth(1200);
        instructScreen.setMinHeight(900);
        this.stage.setScene(new Scene(instructScreen));
        Button getBackMenu = instructScreen.getBackMenu();
        getBackMenu.setOnAction(e -> {
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
