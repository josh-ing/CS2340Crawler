package quack.views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import quack.models.GameObject;
import quack.models.Room;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import quack.models.tilesets.TileSet;
import quack.models.tilesets.OutsideTileSet;
import quack.views.components.ImageViewGrid;

import java.util.ArrayList;

public class GameScreen extends StackPane {

    private Text goldText;
    private Font goldFont;
    private ImageViewGrid roomGrid;
    private ImageViewGrid gameObjectGrid;
    private TileSet currentTileSet = new OutsideTileSet();

    private final int ROWS = 18;
    private final int COLUMNS = 24;
    private final int DIMENSIONS = 50;


    public GameScreen() {
        super();
        roomGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        gameObjectGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        this.getChildren().addAll(roomGrid, gameObjectGrid);
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
            gameObjectGrid.setImage(go.getImageAsset(), go.getRow(), go.getCol());
        }
    }

    public Text getGoldText() {
        return goldText;
    }

    public void setGoldText(Text goldText) {
        this.goldText = goldText;
    }

    public Font getGoldFont() {
        return goldFont;
    }

    public void setGoldFont(Font goldFont) {
        this.goldFont = goldFont;
    }
}
