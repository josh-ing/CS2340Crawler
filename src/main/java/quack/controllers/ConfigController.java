package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.models.PlayerModel;
import quack.models.Room;
import quack.models.characters.PlayableCharacterModel;
import quack.views.ConfigScreen;

import java.io.FileNotFoundException;

/**
 * Controller for ConfigScreen
 */
public class ConfigController extends Controller {
    private ConfigScreen configure;

    public ConfigController (Stage stage) {super(stage);}

    public void initConfig() throws FileNotFoundException {
        configure = new ConfigScreen();
        configure.setMinWidth(1200);
        configure.setMinHeight(900);
        stage.setScene(new Scene(configure));

        PlayableCharacterModel character = new PlayableCharacterModel(3, 3, 3, 3, configure.getDuck());
        Button startGame = configure.getStartButton();
        startGame.setOnAction(e -> {
            if (this.checkFields()) {
                PlayerModel player = new PlayerModel(configure.getPlayerName(), character, getGold());
                toGameScreen(player);

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

    public void toGameScreen(PlayerModel player) {
        int[][] intMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {6, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5},
                {6, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        Room[] neighbors = {null, null, null, null};

        Room room = new Room(intMap, Room.RoomType.MONSTER, neighbors, Room.TileSetType.DUNGEON);
        GameController gameController = new GameController(stage);
        gameController.initGame(room, player);
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
