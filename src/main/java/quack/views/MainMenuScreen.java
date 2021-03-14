package quack.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenuScreen extends VBox {

    private Button newGameButton;

    public MainMenuScreen() throws FileNotFoundException {
        super();
        Font font1;
        String fontFamily = "Tw Cen MT";
        FontWeight fontWeight = FontWeight.BOLD;
        double fontSize = 50;
        Image image = new Image(new FileInputStream("src/main/resources/assets/QuackMove.gif"));

        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO, false, false, true, false);
        Background background = new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size));


        BackgroundFill backgroundFillBut = new BackgroundFill(Color.MOCCASIN,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(backgroundFillBut);

        font1 = Font.font(fontFamily, fontWeight, fontSize);
        newGameButton = new Button("Play");
        newGameButton.setBackground(background1);
        newGameButton.setFont(font1);
        newGameButton.setTranslateY(-200);
        newGameButton.setTranslateX(-200);

        this.setBackground(background);
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().add(newGameButton);
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

    public void setNewGameButton(Button newGameButton) {
        this.newGameButton = newGameButton;
    }
}
