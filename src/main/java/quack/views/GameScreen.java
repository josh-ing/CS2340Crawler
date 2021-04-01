package quack.views;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import quack.models.GameObject;
import quack.models.Room;
import quack.models.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.Node;
import quack.views.components.ImageViewGrid;

import javax.swing.text.html.ImageView;

public class GameScreen extends StackPane {

    static final int TILE_SIZE = 50;
    private Text goldText;
    private Font goldFont;
    private ImageViewGrid roomGrid;
    private ImageViewGrid gameObjectGrid;

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
                try {
                    if (map[r][c] == Room.RoomCellType.FLOOR) {
                        tile = new Image(new FileInputStream("src/main/resources/assets/tiles/dungeon_floor.jpg"));
                    } else if (map[r][c] == Room.RoomCellType.WALL) {
                        tile = new Image(new FileInputStream("src/main/resources/assets/tiles/dungeon_wall.jpg"));
                    } else if (map[r][c] == Room.RoomCellType.NORTH || map[r][c] == Room.RoomCellType.EAST
                            || map[r][c] == Room.RoomCellType.SOUTH || map[r][c] == Room.RoomCellType.WEST) {
                        tile = new Image(new FileInputStream("src/main/resources/assets/tiles/portal.jpg"));
                    } else {
                        tile = new Image(new FileInputStream("src/main/resources/assets/tiles/dungeon_floor.jpg"));
                    }
                    roomGrid.setImage(tile, r, c);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void updateGameObjectGrid(GameObject[] gameObjects) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                roomGrid.setImage(null, r, c);
            }
        }
        for (GameObject go: gameObjects) {
            roomGrid.setImage(go.getImageAsset(), go.getX(), go.getY());
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
