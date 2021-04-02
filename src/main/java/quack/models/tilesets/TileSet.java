package quack.models.tilesets;

import javafx.scene.image.Image;
import quack.models.Room;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class TileSet {

    private Image floor;
    private Image wallLeft;
    private Image wallRight;
    private Image wallUp;
    private Image wallDown;
    private Image wallULCorner;
    private Image wallURCorner;
    private Image wallLLCorner;
    private Image wallLRCorner;
    private Image obstruction;
    private Image portal;

    public TileSet(String tileSetRoot) {
        try {
            this.floor = new Image(new FileInputStream(tileSetRoot + "/floor.png"));
            this.wallLeft = new Image(new FileInputStream(tileSetRoot + "/wallLeft.png"));
            this.wallRight = new Image(new FileInputStream(tileSetRoot + "/wallRight.png"));
            this.wallUp = new Image(new FileInputStream(tileSetRoot + "/wallUp.png"));
            this.wallDown = new Image(new FileInputStream(tileSetRoot + "/wallDown.png"));
            this.wallULCorner = new Image(new FileInputStream(tileSetRoot + "/wallULCorner.png"));
            this.wallURCorner = new Image(new FileInputStream(tileSetRoot + "/wallURCorner.png"));
            this.wallLLCorner = new Image(new FileInputStream(tileSetRoot + "/wallLLCorner.png"));
            this.wallLRCorner = new Image(new FileInputStream(tileSetRoot + "/wallLRCorner.png"));
            this.obstruction = new Image(new FileInputStream(tileSetRoot + "/portal.png"));
            this.portal = new Image(new FileInputStream(tileSetRoot + "/portal.png"));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load tileset.");
        }
    }

    public Image getTileImage(Room.RoomCellType cellType) {
        switch (cellType) {
        case FLOOR:
            return floor;

        case LEFT_WALL:
            return wallLeft;

        case RIGHT_WALL:
            return wallRight;

        case UP_WALL:
            return wallUp;

        case DOWN_WALL:
            return wallDown;

        case UL_WALL:
            return wallULCorner;

        case UR_WALL:
            return wallURCorner;

        case LL_WALL:
            return wallLLCorner;

        case LR_WALL:
            return wallLRCorner;

        case OBSTRUCTION:
            return obstruction;

        default:
            return portal;
        }
        //Logic to return the correct image based on cellType
    }
}
