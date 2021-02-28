package quack;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.controllers.Controller;
import quack.controllers.MainMenuController;
import quack.controllers.MapController;
import quack.views.ConfigScreen;
import quack.views.MainMenuScreen;
import sun.applet.Main;
import quack.models.Room;

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


//        MainMenuController mainMenuController = new MainMenuController(stage);
//        mainMenuController.initMainMenu();

        int[][] intMap = {
                {1, 1, 1, 1, 1, 3, 3, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {6, 0, 0, 0, 0, 0, 0, 5},
                {6, 0, 0, 0, 0, 0, 0, 5},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 4, 4, 1, 1, 1}
        };

        Room[] neighbors = {null, null, null, null};

        Room room = new Room(intMap, Room.RoomType.MONSTER, neighbors, Room.TileSetType.DUNGEON);
        MapController mapController = new MapController(stage);
        mapController.initMap(room);
    }
}
