package quack.views;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
     */
    public ConfigScreen() throws FileNotFoundException {
        super();

        //Name Field
        nameField = new TextField();
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
        difficultySelection.getChildren().addAll(difficultyLabel, difficultyEasy, difficultyMedium, difficultyHard);
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

        //Duck images
        HBox imageWrapper = new HBox();
        final ImageView selectedImage1 = new ImageView();
        final ImageView selectedImage2 = new ImageView();
        final ImageView selectedImage3 = new ImageView();
        Image image1 = new Image(new FileInputStream("D:\\Documents\\CS2340-Dungeon-Crawler\\src\\main\\resources\\assets\\duck1.jpg"));
        Image image2 = new Image(new FileInputStream("D:\\Documents\\CS2340-Dungeon-Crawler\\src\\main\\resources\\assets\\duck2.jpg"));
        Image image3 = new Image(new FileInputStream("D:\\Documents\\CS2340-Dungeon-Crawler\\src\\main\\resources\\assets\\duck3.jpg"));
        selectedImage1.setImage(image1);
        selectedImage1.setFitHeight(250);
        selectedImage1.setFitWidth(250);
        selectedImage2.setImage(image2);
        selectedImage2.setFitHeight(250);
        selectedImage2.setFitWidth(250);
        selectedImage3.setImage(image3);
        selectedImage3.setFitHeight(250);
        selectedImage3.setFitWidth(250);
        imageWrapper.getChildren().addAll(selectedImage1, selectedImage2, selectedImage3);
        imageWrapper.setAlignment(Pos.CENTER);
        imageWrapper.setSpacing(30);

        //Choose duck
        /**
         * TODO: decide which duck types we want the player to select
         */
        HBox duckSelection = new HBox();
        Label duckLabel = new Label("Choose your character");
        duckGroup = new ToggleGroup();
        RadioButton duck1 = new RadioButton("Duck1");
        RadioButton duck2 = new RadioButton("Duck2");
        RadioButton duck3 = new RadioButton("Duck3");
        duck1.setToggleGroup(duckGroup);
        duck2.setToggleGroup(duckGroup);
        duck3.setToggleGroup(duckGroup);
        duckSelection.getChildren().addAll(duckLabel, duck1, duck2, duck3);
        duckSelection.setAlignment(Pos.CENTER);
        duckSelection.setSpacing(200);

        this.getChildren().addAll(nameWrapper, difficultySelection, weaponSelection, imageWrapper, duckSelection, startWrapper);
        this.setSpacing(30);
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
     * Returns the difficulty level as an integer. Ranges from 1 to 3, 1 being the easier and 3 being the most difficult.
     *
     * TODO: Modify this method to have a more intuitive way to return the difficulty.
     * @return Integer value representing the difficulty of the game.
     */
    public int getDifficulty() {
        ArrayList<String> difficulties = new ArrayList<>();
        difficulties.add("Easy");
        difficulties.add("Medium");
        difficulties.add("Hard");
        RadioButton difficulty = (RadioButton)difficultyGroup.getSelectedToggle();
        if (difficulty == null) {
            return -1;
        } else {
            return difficulties.indexOf(difficulty.getText());
        }
    }

    /**
     * Returns value of weapon as integer. 1 = Toaster bow, 2 = butter knife, 3 = wand
     * @return Integer value of the corresponding weapon
     */
    public int getWeapon() {
        ArrayList<String> weapons = new ArrayList<>();
        weapons.add("Toaster Bow");
        weapons.add("Butter knife");
        weapons.add("Wand");
        RadioButton weapon = (RadioButton)weaponGroup.getSelectedToggle();
        if (weapon == null) {
            return -1;
        } else {
            return weapons.indexOf(weapon.getText());
        }
    }

    /**
     * Returns duck character as integer.
     * TODO: change names of ducks
     * @return Integer value of the corresponding duck
     */
    public int getDuck() {
        ArrayList<String> duck = new ArrayList<>();
        duck.add("Duck1");
        duck.add("Duck2");
        duck.add("Duck3");
        RadioButton ducks = (RadioButton)duckGroup.getSelectedToggle();
        if (duck == null) {
            return -1;
        } else {
            return duck.indexOf(ducks.getText());
        }
    }

    /**
     * Checks whether or not the config setup entered by the player is valid.
     * TODO: (Probably) move this logic into a controller...
     * @return A boolean on whether all the fields are valid.
     */
    private boolean checkFields() {
        String nameText = nameField.getText().trim();
        boolean validName = !(nameText.equals("") || nameText == null);
        boolean validDifficulty = difficultyGroup.getSelectedToggle() != null;
        return validName && validDifficulty;


    }
}
