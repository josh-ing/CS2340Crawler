package quack.views;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import quack.views.components.SelectCharacterWrapper;
import quack.views.components.SelectWeaponWrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A class that represents the config screen component. Extends VBox.
 */
public class ConfigScreen extends VBox {

    private TextField nameField;
    private ToggleGroup difficultyGroup;
    private Button startButton;
    private ToggleGroup weaponGroup;
    private ToggleGroup duckGroup;

    /**
     * Constructor initializing all the fields for the config screen.
     * @throws FileNotFoundException if the file is not found.
     */
    public ConfigScreen() throws FileNotFoundException {
        super();

        //Text formatting
        Font font1;
        String fontFamily = "Tw Cen MT";
        FontWeight fontWeight = FontWeight.BOLD;
        double fontSize = 20;

        font1 = Font.font(fontFamily, fontWeight, fontSize);

        //Background image
        String input = "src/main/resources/assets/tiles/";
        Image image = new Image(new FileInputStream(input + "backgroundConfig.png"));

        BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO,
            BackgroundSize.AUTO, false, false, true, false);
        Background background = new Background(new BackgroundImage(image,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, size));

        //Name Field
        nameField = new TextField();
        nameField.setText("Quacky");
        Label nameLabel = new Label("Enter your name!");
        nameLabel.setFont(font1);
        HBox nameWrapper = new HBox(nameLabel, nameField);
        nameWrapper.setAlignment(Pos.CENTER);
        nameWrapper.setSpacing(10);

        //Difficulty Field
        HBox difficultySelection = new HBox();
        Label difficultyLabel = new Label("Select Difficulty");
        difficultyLabel.setFont(font1);
        difficultyGroup = new ToggleGroup();
        RadioButton difficultyEasy = new RadioButton("Easy");
        difficultyEasy.setFont(font1);
        RadioButton difficultyMedium = new RadioButton("Medium");
        difficultyMedium.setFont(font1);
        RadioButton difficultyHard = new RadioButton("Hard");
        difficultyHard.setFont(font1);
        difficultyEasy.setToggleGroup(difficultyGroup);
        difficultyMedium.setToggleGroup(difficultyGroup);
        difficultyHard.setToggleGroup(difficultyGroup);
        difficultySelection.getChildren().addAll(difficultyLabel, difficultyEasy,
                difficultyMedium, difficultyHard);
        difficultySelection.setAlignment(Pos.CENTER);
        difficultySelection.setSpacing(15);

        //Start Game Button
        startButton = new Button("Start Game");
        startButton.setFont(font1);
        HBox startWrapper = new HBox(startButton);
        startWrapper.setAlignment(Pos.BOTTOM_CENTER);
        startWrapper.setTranslateY(200);



        //select weapon label
        HBox selectWeapon = new HBox();
        Label weaponLabel = new Label("Choose your weapon");
        weaponLabel.setFont(font1);
        selectWeapon.getChildren().addAll(weaponLabel);
        selectWeapon.setAlignment(Pos.CENTER);

        //Weapon images
        HBox imageWrapperWeapon = new HBox();
        weaponGroup = new ToggleGroup();
        SelectWeaponWrapper katana = new SelectWeaponWrapper(
            "src/main/resources/assets/weapons/katana.png", "Katana", weaponGroup);
        SelectWeaponWrapper knife = new SelectWeaponWrapper(
            "src/main/resources/assets/weapons/knife.png", "Knife", weaponGroup);
        SelectWeaponWrapper sword = new SelectWeaponWrapper(
            "src/main/resources/assets/weapons/sword.png", "Sword", weaponGroup);

        imageWrapperWeapon.getChildren().addAll(katana, knife, sword);
        imageWrapperWeapon.setAlignment(Pos.CENTER);

        //select character label
        HBox select = new HBox();
        Label selection = new Label("Choose your character!");
        selection.setFont(font1);
        select.getChildren().addAll(selection);
        select.setAlignment(Pos.CENTER);

        //Duck images
        HBox imageWrapperTotal = new HBox();
        duckGroup = new ToggleGroup();
        SelectCharacterWrapper quack = new SelectCharacterWrapper(
                "src/main/resources/assets/quack.gif", "Quack", duckGroup);
        SelectCharacterWrapper henry = new SelectCharacterWrapper(
                "src/main/resources/assets/henry.gif", "Henry", duckGroup);
        SelectCharacterWrapper chicken = new SelectCharacterWrapper(
                "src/main/resources/assets/chicken.gif", "Chicken", duckGroup);

        imageWrapperTotal.getChildren().addAll(quack, henry, chicken);
        imageWrapperTotal.setAlignment(Pos.CENTER);

        this.getChildren().addAll(nameWrapper, difficultySelection,
                selectWeapon, imageWrapperWeapon, select, imageWrapperTotal, startWrapper);
        this.setBackground(background);
        this.setSpacing(20);
    }

    /**
     * Returns the start button.
     * @return A Button representing the start button.
     */
    public Button getStartButton() {
        return startButton;
    }

    /**
     * Returns the player's name that they entered in the config screen.
     * @return String representing the player's name
     */
    public String getPlayerName() {
        return nameField.getText();
    }

    /**
     * Returns the difficulty level as a String
     *
     *
     * @return Integer value representing the difficulty of the game.
     */
    public String getDifficulty() {
        RadioButton difficulty = (RadioButton) difficultyGroup.getSelectedToggle();
        if (difficulty == null) {
            return null;
        }
        return difficulty.getText();
    }

    /**
     * Returns value of weapon as String
     * @return Integer value of the corresponding weapon
     */
    public String getWeapon() {
        RadioButton weapon = (RadioButton) weaponGroup.getSelectedToggle();
        if (weapon == null) {
            return null;
        }
        return weapon.getText();
    }

    /**
     * Returns duck character as string.
     * @return Integer value of the corresponding duck
     */
    public String getDuck() {
        RadioButton ducks = (RadioButton) duckGroup.getSelectedToggle();
        if (ducks == null) {
            return null;
        } else {
            return ducks.getText().toLowerCase();
        }
    }


}
