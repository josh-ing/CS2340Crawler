package quack.views;

import javafx.scene.layout.Pane;
import quack.models.Room;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class MapScreen extends Pane {

    static final int TILE_SIZE = 50;

    public MapScreen(Room room) {
        super();

        Room.RoomCellType[][] map = room.getMap();
        ArrayList tiles = new ArrayList<>();

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

                tiles.add(r);
            }
        }

        this.getChildren().addAll(tiles);
    }
}
