package quack.models.tilesets;

import javafx.scene.image.Image;
import quack.models.GameState;
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
        if (GameState.getInstance().getPlayer().getDifficulty().equals("Easy")) {
            try {
                this.floor = new Image(new FileInputStream(tileSetRoot + "/floor.png"));
                this.wallLeft = new Image(new FileInputStream(tileSetRoot + "/wallLeft.png"));
                this.wallRight = new Image(new FileInputStream(tileSetRoot + "/wallRight.png"));
                this.wallUp = new Image(new FileInputStream(tileSetRoot + "/wallUp.png"));
                this.wallDown = new Image(new FileInputStream(tileSetRoot + "/wallDown.png"));
                this.wallULCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallULCorner.png"));
                this.wallURCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallURCorner.png"));
                this.wallLLCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLLCorner.png"));
                this.wallLRCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLRCorner.png"));
                this.obstruction =
                    new Image(new FileInputStream(tileSetRoot + "/dungeon_wall.png"));
                this.portal = new Image(new FileInputStream(tileSetRoot + "/portal.png"));
            } catch (FileNotFoundException e) {
                System.out.println("Cannot load tileset.");
            }
        }
        if (GameState.getInstance().getPlayer().getDifficulty().equals("Medium")) {
            try {
                this.floor = new Image(new FileInputStream(tileSetRoot + "/floorMedium.png"));
                this.wallLeft = new Image(new FileInputStream(tileSetRoot + "/wallLeftMedium.png"));
                this.wallRight = new Image(new FileInputStream(tileSetRoot + "/wallRightMedium.png"));
                this.wallUp = new Image(new FileInputStream(tileSetRoot + "/wallUpMedium.png"));
                this.wallDown = new Image(new FileInputStream(tileSetRoot + "/wallDownMedium.png"));
                this.wallULCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallULCornerMedium.png"));
                this.wallURCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallURCornerMedium.png"));
                this.wallLLCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLLCornerMedium.png"));
                this.wallLRCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLRCornerMedium.png"));
                this.obstruction =
                    new Image(new FileInputStream(tileSetRoot + "/dungeon_wall.png"));
                this.portal = new Image(new FileInputStream(tileSetRoot + "/portal.png"));
            } catch (FileNotFoundException e) {
                System.out.println("Cannot load tileset.");
            }
        }
        if (GameState.getInstance().getPlayer().getDifficulty().equals("Hard")) {
            try {
                this.floor = new Image(new FileInputStream(tileSetRoot + "/floorHard.png"));
                this.wallLeft = new Image(new FileInputStream(tileSetRoot + "/wallLeftHard.png"));
                this.wallRight = new Image(new FileInputStream(tileSetRoot + "/wallRightHard.png"));
                this.wallUp = new Image(new FileInputStream(tileSetRoot + "/wallUpHard.png"));
                this.wallDown = new Image(new FileInputStream(tileSetRoot + "/wallDownHard.png"));
                this.wallULCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallULCornerhard.png"));
                this.wallURCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallURCornerHard.png"));
                this.wallLLCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLLCornerHard.png"));
                this.wallLRCorner =
                    new Image(new FileInputStream(tileSetRoot + "/wallLRCornerHard.png"));
                this.obstruction =
                    new Image(new FileInputStream(tileSetRoot + "/dungeon_wall.png"));
                this.portal = new Image(new FileInputStream(tileSetRoot + "/portal.png"));
            } catch (FileNotFoundException e) {
                System.out.println("Cannot load tileset.");
            }
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
