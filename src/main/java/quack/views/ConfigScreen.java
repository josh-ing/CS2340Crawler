package quack.views;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * A class that represents the config screen component. Extends VBox.
 */
public class ConfigScreen extends VBox {

    private TextField nameField;
    private ToggleGroup difficultyGroup;
    private Button startButton;

    /**
     * Constructor initializing all the fields for the config screen.
     */
    public ConfigScreen() {
        super();

        //Name Field
        nameField = new TextField();
        Label nameLabel = new Label("Enter your name!");
        HBox nameWrapper = new HBox(nameLabel, nameField);
        nameWrapper.setAlignment(Pos.CENTER);
        nameWrapper.setSpacing(10);

        //Difficulty Field
        VBox difficultySelection = new VBox();
        Label difficultyLabel = new Label("Select Difficulty");
        difficultyGroup = new ToggleGroup();
        RadioButton difficultyEasy = new RadioButton("Easy");
        RadioButton difficultyMedium = new RadioButton("Medium");
        RadioButton difficultyHard = new RadioButton("Hard");
        difficultyEasy.setToggleGroup(difficultyGroup);
        difficultyMedium.setToggleGroup(difficultyGroup);
        difficultyHard.setToggleGroup(difficultyGroup);
        difficultySelection.getChildren().addAll(difficultyLabel, difficultyEasy, difficultyMedium, difficultyHard);

        //Start Game Button
        startButton = new Button("Start Game");

        //Test Button (Remove Later)
        Button testButton = new Button("Test");
        testButton.setOnAction(e -> System.out.println(checkFields()));


        this.getChildren().addAll(nameWrapper, difficultySelection, testButton, startButton);
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
     * Checks whether or not the config setup entered by the player is valid.
     * @return A boolean on whether all the fields are valid.
     */
    private boolean checkFields() {
        String nameText = nameField.getText().trim();
        boolean validName = !(nameText.equals("") || nameText == null);
        boolean validDifficulty = difficultyGroup.getSelectedToggle() != null;
        return validName && validDifficulty;


    }
}
