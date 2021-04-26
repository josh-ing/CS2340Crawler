package quack;

import javafx.application.Application;
import javafx.stage.Stage;
import quack.controllers.MainMenuController;
import quack.controllers.WinScreenController;

public class QuackApp extends Application {

    protected Stage stage;
    private final int width = 1200;
    private final int height = 900;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Quack");
        stage.setResizable(false);

        MainMenuController mainMenuController = new MainMenuController(stage);
        mainMenuController.initMainMenu();
    }
}
