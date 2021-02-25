package quack.controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import quack.views.ConfigScreen;
import quack.views.MapScreen;
import quack.models.Room;

/**
 * Controller for MainMenuScreen
 */
public class MapController extends Controller {

    /**
     * Initializes the controller with a stage.
     * @param stage
     */
    public MapController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show map.
     */
    public void initMap(Room room) {
        MapScreen mapScreen = new MapScreen(room);
        this.stage.setScene(new Scene(mapScreen));
        stage.show();
    }
}
