package quack.models.tilesets;

import javafx.scene.image.Image;
import quack.models.Room;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class TileSet {

    private Image floor;
    private Image wall;
    private Image portal;

    public TileSet(String floor, String wall, String portal) {
        try {
            this.floor = new Image(new FileInputStream(floor));
            this.wall = new Image(new FileInputStream(wall));
            this.portal = new Image(new FileInputStream(portal));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load tileset.");
        }
    }

    public Image getTileImage(Room.RoomCellType cellType) {
        if (cellType == Room.RoomCellType.FLOOR) {
            return floor;
        } else if (cellType == Room.RoomCellType.WALL) {
            return wall;
        } else {
            return portal;
        }
        //Logic to return the correct image based on cellType
    }
}
