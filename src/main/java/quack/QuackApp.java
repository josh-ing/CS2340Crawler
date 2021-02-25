package quack;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.controllers.Controller;
import quack.controllers.MainMenuController;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;
import sun.applet.Main;

public class QuackApp extends Application {

    protected Stage stage;
    private final int width = 500;
    private final int height = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Quack");


        MainMenuController mainMenuController = new MainMenuController(stage);
        mainMenuController.initMainMenu();
    }




}
