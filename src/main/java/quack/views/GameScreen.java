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

    /**
    public void render() {
        this.getChildren().clear();

        Font goldFont = Font.font("Arial", FontWeight.BOLD, 25.0);
        goldText = new Text(10, 35, "GOLD: ");
        goldText.setFill(Color.WHITE);
        goldText.setFont(goldFont);

        Room.RoomCellType[][] map = room.getMap();
        ArrayList elements = new ArrayList<>();

        double playerWidth = 10;
        double playerHeight = 10;

        playerNode = new Rectangle(10, 10);
        double playerX = player.getX() * TILE_SIZE + ((TILE_SIZE - playerWidth))/2;
        double playerY = player.getY() * TILE_SIZE + ((TILE_SIZE - playerHeight))/2;


        playerNode.setTranslateX(playerX);
        playerNode.setTranslateY(playerY);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int y = i * TILE_SIZE;
                int x = j * TILE_SIZE;
                StackPane stack = new StackPane();

                Rectangle r = new Rectangle(TILE_SIZE, TILE_SIZE);

                Room.RoomCellType cellType = map[i][j];

                Text text = new Text(cellType.name());

                stack.getChildren().addAll(r, text);

                stack.setTranslateX(x);
                stack.setTranslateY(y);

                switch (cellType) {
                case FLOOR:
                    r.setFill(Color.BEIGE);
                    break;

                case WALL:
                    r.setFill(Color.GRAY);
                    break;

                case NORTH:
                    r.setFill(Color.BLUE);
                    break;

                case SOUTH:
                    r.setFill(Color.BLUEVIOLET);
                    break;

                case EAST:
                    r.setFill(Color.ALICEBLUE);
                    break;

                case WEST:
                    r.setFill(Color.CORNFLOWERBLUE);
                    break;
                default:
                    break;
                }
                elements.add(stack);
            }
        }

        elements.add(playerNode);
        elements.add(goldText);
        this.getChildren().addAll(elements);
    }*/

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
