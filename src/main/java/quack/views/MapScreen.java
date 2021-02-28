package quack.views;

import javafx.scene.layout.Pane;
import quack.models.Room;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;

public class MapScreen extends Pane {

    static final int TILE_SIZE = 50;

    Text goldText;

    public MapScreen(Room room) {
        super();

        Font goldFont = Font.font("Arial", FontWeight.BOLD, 25.0);
        goldText = new Text(10, 35, "GOLD: ");
        goldText.setFill(Color.WHITE);
        goldText.setFont(goldFont);

        Room.RoomCellType[][] map = room.getMap();
        ArrayList elements = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = i * TILE_SIZE;
                int y = j * TILE_SIZE;
                Rectangle r = new Rectangle(x, y, TILE_SIZE, TILE_SIZE);

                Room.RoomCellType cellType = map[i][j];

                switch (cellType) {
                    case FLOOR:
                        r.setFill(Color.BEIGE);
                        break;

                    case WALL:
                        r.setFill(Color.BLACK);
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
                }

                elements.add(r);
            }
        }

        elements.add(goldText);
        this.getChildren().addAll(elements);
    }

    public Text getGoldText() {
        return goldText;
    }
}
