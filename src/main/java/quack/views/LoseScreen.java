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

/**
 * A class that represents the lose screen component. Extends VBox.
 */
public class LoseScreen extends VBox {

    private Button menuButton;

    /**
     * Constructor initializing all the fields for the lose screen.
     *
     */
    public LoseScreen() {
        super();
        Font font1;
        String fontFamily = "Tw Cen MT";
        FontWeight fontWeight = FontWeight.BOLD;
        double fontSize = 40;


        try {
            Image image = new Image(new FileInputStream(
                    "src/main/resources/assets/LoseScreen.gif"));

            BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO, false, false, true, false);
            Background background = new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size));

            this.setBackground(background);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        BackgroundFill backgroundFillBut = new BackgroundFill(Color.DARKSEAGREEN,
            CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(backgroundFillBut);

        font1 = Font.font(fontFamily, fontWeight, fontSize);
        menuButton = new Button("Play Again!");
        menuButton.setBackground(background1);
        menuButton.setFont(font1);
        menuButton.setTranslateY(-100);
        menuButton.setTranslateX(-430);


        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().add(menuButton);
    }

    /**
     * Returns the menu button.
     * @return A Button representing the menu button.
     */
    public Button getMenuButton() {
        return menuButton;
    }

    /**
     * Sets the menu button.
     * @param menuButton A Button representing the menu button.
     */
    public void setMenuButton(Button menuButton) {
        this.menuButton = menuButton;
    }
}



