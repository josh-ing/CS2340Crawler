package quack.views;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import quack.views.components.SelectCharacterWrapper;
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

        //Name Field
        nameField = new TextField();
        nameField.setText("Quacky");
        Label nameLabel = new Label("Enter your name!");
        HBox nameWrapper = new HBox(nameLabel, nameField);
        nameWrapper.setAlignment(Pos.CENTER);
        nameWrapper.setSpacing(10);

        //Difficulty Field
        HBox difficultySelection = new HBox();
        Label difficultyLabel = new Label("Select Difficulty");
        difficultyGroup = new ToggleGroup();
        RadioButton difficultyEasy = new RadioButton("Easy");
        RadioButton difficultyMedium = new RadioButton("Medium");
        RadioButton difficultyHard = new RadioButton("Hard");
        difficultyEasy.setToggleGroup(difficultyGroup);
        difficultyMedium.setToggleGroup(difficultyGroup);
        difficultyHard.setToggleGroup(difficultyGroup);
        difficultySelection.getChildren().addAll(difficultyLabel, difficultyEasy,
                difficultyMedium, difficultyHard);
        difficultySelection.setAlignment(Pos.CENTER);
        difficultySelection.setSpacing(15);

        //Start Game Button
        startButton = new Button("Start Game");
        HBox startWrapper = new HBox(startButton);
        startWrapper.setAlignment(Pos.CENTER);


        //Select Weapon Button
        HBox weaponSelection = new HBox();
        Label weaponLabel = new Label("Choose your weapon");
        weaponGroup = new ToggleGroup();
        RadioButton weaponToaster = new RadioButton("Toaster Bow");
        RadioButton weaponKnife = new RadioButton("Butter knife");
        RadioButton weaponWand = new RadioButton("Wand");
        weaponToaster.setToggleGroup(weaponGroup);
        weaponKnife.setToggleGroup(weaponGroup);
        weaponWand.setToggleGroup(weaponGroup);
        weaponSelection.getChildren().addAll(weaponLabel, weaponToaster, weaponKnife, weaponWand);
        weaponSelection.setAlignment(Pos.CENTER);
        weaponSelection.setSpacing(15);

        //select character label
        HBox select = new HBox();
        Label selection = new Label("Choose your character!");
        select.getChildren().addAll(selection);
        select.setAlignment(Pos.CENTER);

        //Duck images
        HBox imageWrapperTotal = new HBox();
        duckGroup = new ToggleGroup();
        SelectCharacterWrapper quack = new SelectCharacterWrapper(
                "src/main/resources/assets/quack.png", "Quack", duckGroup);
        SelectCharacterWrapper henry = new SelectCharacterWrapper(
                "src/main/resources/assets/henry.png", "Henry", duckGroup);
        SelectCharacterWrapper pelican = new SelectCharacterWrapper(
                "src/main/resources/assets/pelican.png", "Pelican", duckGroup);

        imageWrapperTotal.getChildren().addAll(quack, henry, pelican);
        imageWrapperTotal.setAlignment(Pos.CENTER);

        this.getChildren().addAll(nameWrapper, difficultySelection,
                weaponSelection, select, imageWrapperTotal, startWrapper);
        this.setSpacing(10);
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
