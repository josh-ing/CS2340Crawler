package quack.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SelectCharacterWrapper extends VBox {
    public SelectCharacterWrapper(String path, String name,
                                  ToggleGroup toggleGroup) throws FileNotFoundException {
        super();
        //Text formatting
        Font font1;
        String fontFamily = "Tw Cen MT";
        FontWeight fontWeight = FontWeight.BOLD;
        double fontSize = 20;

        font1 = Font.font(fontFamily, fontWeight, fontSize);

        FileInputStream fileInputStream = new FileInputStream(path);
        Image image = new Image(fileInputStream);
        ImageView imageView = new ImageView(image);
        RadioButton radioButton = new RadioButton(name);
        radioButton.setFont(font1);
        radioButton.setToggleGroup(toggleGroup);
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        this.getChildren().addAll(imageView, radioButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(4);
    }


}
