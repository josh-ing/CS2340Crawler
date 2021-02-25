package quack.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuScreen extends VBox {

    Button newGameButton;

    public MainMenuScreen() {
        super();

        Label welcomeLabel = new Label("Welcome to the main menu...");
        newGameButton = new Button("Start Game");

        this.getChildren().addAll(welcomeLabel, newGameButton);
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

}
