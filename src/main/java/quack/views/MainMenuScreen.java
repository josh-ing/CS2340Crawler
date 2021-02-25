package quack.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuScreen extends VBox {

    Button startButton;

    public MainMenuScreen() {
        super();

        Label welcomeLabel = new Label("Welcome to the main menu...");
        startButton = new Button("Start Game");

        this.getChildren().addAll(welcomeLabel, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }

}
