package quack.views;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import quack.models.Room;
import quack.models.PlayerModel;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;

public class GameScreen extends Pane {

    static final int TILE_SIZE = 50;
    private Text goldText;
    private Font goldFont;
    private Room room;
    private PlayerModel player;

    public GameScreen(Room room, PlayerModel player) {
        super();

        this.room = room;
        this.player = player;
        this.setRoom(room);
    }

    public void setRoom(Room room) {
        this.room = room;

        this.getChildren().clear();

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

        elements.add(goldText);
        this.getChildren().addAll(elements);
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
