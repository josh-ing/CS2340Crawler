package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.models.GameState;
import quack.models.Player;
import quack.models.Room;
import quack.models.characters.Character;
import quack.models.characters.QuackCharacter;
import quack.views.ConfigScreen;
import quack.models.RoomGenerator;
import java.io.FileNotFoundException;

/**
 * Controller for ConfigScreen
 */
public class ConfigController extends Controller {
    private ConfigScreen configure;

    public ConfigController(Stage stage) {
        super(stage);
    }

    public void initConfig() throws FileNotFoundException {
        configure = new ConfigScreen();
        configure.setMinWidth(1200);
        configure.setMinHeight(900);
        stage.setScene(new Scene(configure));

        // Implement logic for creating different character types.
        Character character = new QuackCharacter();

        Button startGame = configure.getStartButton();
        startGame.setOnAction(e -> {
            if (this.checkFields()) {
                Player player = new Player(configure.getPlayerName(),
                        character, getGold());

                player.setImageAsset(character.getSpriteAsset());

                GameState.getInstance().setPlayer(player);
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
     * Field for checking if fields are null
     * @return Boolean value if any input is null
     */
    private boolean checkFields() {
        String nameText = configure.getPlayerName();
        boolean validName = !(nameText.trim().equals("") || nameText == null);
        boolean validDifficulty = configure.getDifficulty() != null;
        boolean validWeapon = configure.getWeapon() != null;
        boolean validDuck = configure.getDuck() != null;
        return validName && validDifficulty && validWeapon && validDuck;
    }

    public void toGameScreen() {
        GameController gameController = new GameController(stage);
        gameController.initGame();
    }

    private int getGold() {
        int goldFromDifficulty = 0;

        if (configure.getDifficulty().equals("Hard")) {
            goldFromDifficulty = 0;
        } else if (configure.getDifficulty().equals("Medium")) {
            goldFromDifficulty = 50;
        } else {
            goldFromDifficulty = 100;
        }

        return goldFromDifficulty;
    }
}
