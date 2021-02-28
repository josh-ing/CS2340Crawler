package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.QuackApp;
import quack.models.PlayerModel;
import quack.models.characters.PlayableCharacterModel;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;

import java.io.FileNotFoundException;

/**
 * Controller for ConfigScreen
 */
public class ConfigController extends Controller {
    private ConfigScreen configure;

    public ConfigController (Stage stage) {super(stage);}

    public void initConfig() throws FileNotFoundException {
        configure = new ConfigScreen();
        stage.setScene(new Scene(configure));
        PlayableCharacterModel character = new PlayableCharacterModel(3, 3, 3, 3, configure.getDuck());
        Button startGame = configure.getStartButton();
        startGame.setOnAction(e -> {
            if (this.checkFields()) {
                PlayerModel player = new PlayerModel(configure.getPlayerName(), character);
                toGameScreen();

            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("You cannot have null values.");
                errorAlert.showAndWait();
            }
        });

    }


    /**
     * Deal with this later
     * @return
     */
    private boolean checkFields() {
        String nameText = configure.getPlayerName();
        boolean validName = !(nameText.equals("") || nameText == null);
        boolean validDifficulty = configure.getDifficulty() != null;
        boolean validWeapon = configure.getWeapon() != null;
        boolean validDuck = configure.getDuck() != null;
        return validName && validDifficulty && validWeapon && validDuck;

    }

    public void toGameScreen() {
        System.out.println("success");
    }


}
