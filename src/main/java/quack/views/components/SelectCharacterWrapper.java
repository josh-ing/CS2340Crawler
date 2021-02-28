package quack.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SelectCharacterWrapper extends VBox {
    public SelectCharacterWrapper(String path, String name, ToggleGroup toggleGroup) throws FileNotFoundException {
        super();
        FileInputStream fileInputStream = new FileInputStream(path);
        Image image = new Image(fileInputStream);
        ImageView imageView = new ImageView(image);
        RadioButton radioButton = new RadioButton(name);
        radioButton.setToggleGroup(toggleGroup);
        imageView.setFitHeight(250);
        imageView.setFitWidth(250);
        this.getChildren().addAll(imageView, radioButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(4);
    }


}
