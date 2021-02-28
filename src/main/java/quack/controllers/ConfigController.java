package quack.controllers;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.QuackApp;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;

import java.io.FileNotFoundException;

/**
 * Controller for ConfigScreen
 */
public class ConfigController extends Controller {
    private int duckType;
    private int weapon;
    private int difficulty;

    public ConfigController (Stage stage) {super(stage);}

    public void initConfig() throws FileNotFoundException {
        ConfigScreen configure = new ConfigScreen();
    }


}
