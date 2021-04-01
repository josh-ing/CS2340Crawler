package quack.models.tilesets;

import javafx.scene.image.Image;
import quack.models.Room;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class TileSet {

    private Image FLOOR;
    private Image WALL;
    private Image PORTAL;

    public TileSet(String floor, String wall, String portal) throws FileNotFoundException {
        FLOOR = new Image(new FileInputStream(floor));
        WALL = new Image(new FileInputStream(wall));
        PORTAL = new Image(new FileInputStream(portal));
    }

    public Image getTileImage(Room.RoomCellType cellType) {
        if (cellType == Room.RoomCellType.FLOOR) {
            return FLOOR;
        } else if (cellType == Room.RoomCellType.WALL) {
            return WALL;
        } else {
            return PORTAL;
        }
        //Logic to return the correct image based on cellType
    }
}
