package quack.models.tilesets;

import javafx.scene.image.Image;
import quack.models.Room;

public abstract class TileSet {

    private Image FLOOR;
    private Image WALL;
    private Image PORTAL;

    public TileSet(String floor, String wall, String portal) {
        //Set FLOOR to be the image loaded from the directory floor.
    }

    public Image getTileImage(Room.RoomCellType cellType) {
        //Logic to return the correct image based on cellType
    }
}
