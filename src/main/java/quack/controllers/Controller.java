package quack.controllers;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;

public class Controller extends Application {

    private Stage stage;
    private final int width = 500;
    private final int height = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Quack");

        //Replace this with main menu screen. Config screen for example purposes...
        ConfigScreen configScreen = new ConfigScreen();
        Scene configScene = new Scene(configScreen);

        initMainMenu();
    }

    /**
     * Initializes app to show main menu.
     */
    private void initMainMenu() {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        stage.setScene(new Scene(mainMenuScreen));
        Button startButton = mainMenuScreen.getStartButton();
        startButton.setOnAction(e -> toConfigScreen());
        stage.show();

    }

    private void toConfigScreen() {
        ConfigScreen configScreen = new ConfigScreen();
        stage.setScene(new Scene(configScreen));
    }
}
