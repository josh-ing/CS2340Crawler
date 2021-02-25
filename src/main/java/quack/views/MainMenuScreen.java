package quack.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class MainMenuScreen extends VBox {

    Button newGameButton;
    Font font1;
    String fontFamily = "Papyrus";
    FontWeight fontWeight = FontWeight.BOLD;
    double fontSize = 35;

    public MainMenuScreen() {
        super();
        BackgroundFill background_fill = new BackgroundFill(Color.NAVAJOWHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        this.setBackground(background);

        BackgroundFill backgroundFillBut = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(backgroundFillBut);

        font1 = Font.font(fontFamily, fontWeight, fontSize);
        Label welcomeLabel = new Label("Adventures of Quack Stabby");
        welcomeLabel.setFont(font1);
        newGameButton = new Button("Play");
        newGameButton.setBackground(background1);
        newGameButton.setFont(font1);

        this.setSpacing(30);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(welcomeLabel, newGameButton);
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

}
