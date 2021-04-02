package quack.views;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import quack.models.GameObject;
import quack.models.Room;
import javafx.scene.text.Text;
import quack.models.tilesets.TileSet;
import quack.models.tilesets.OutsideTileSet;
import quack.views.components.ImageViewGrid;

import java.util.ArrayList;

public class GameScreen extends Pane {

    private Text goldText = new Text("GOLD");
    private Text healthText = new Text("HEALTH");
    private ImageViewGrid roomGrid;
    private ImageViewGrid gameObjectGrid;
    private TileSet currentTileSet = new OutsideTileSet();

    static final int ROWS = 18;
    static final int COLUMNS = 24;
    static final int DIMENSIONS = 50;


    public GameScreen() {
        super();
        goldText.setX(10);
        goldText.setY(30);

        healthText.setX(10);
        healthText.setY(50);

        roomGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        gameObjectGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        this.getChildren().addAll(roomGrid, gameObjectGrid, goldText, healthText);
    }

    public void updateRoomGrid(Room.RoomCellType[][] map) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                Image tile;
                tile = currentTileSet.getTileImage(map[r][c]);
                roomGrid.setImage(tile, r, c);
            }
        }
    }

    public void updateGameObjectGrid(ArrayList<GameObject> gameObjects) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                gameObjectGrid.setImage(null, r, c);
            }
        }
        for (GameObject go: gameObjects) {
            gameObjectGrid.setImage(go.getImageAsset(),
                    go.getPosition().getRow(), go.getPosition().getCol());
        }
    }

    public void setHealth(int health) {
        healthText.setText("HEALTH: " + health);
    }

    public void setGold(int gold) {
        goldText.setText("GOLD: " + gold);
    }
}
