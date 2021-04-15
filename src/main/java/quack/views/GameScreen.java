package quack.views;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Renderable;
import quack.models.Room;
import javafx.scene.text.Text;
import quack.models.items.Inventory;
import quack.models.items.Item;
import quack.models.tilesets.TileSet;
import quack.models.tilesets.OutsideTileSet;
import quack.views.components.ImageViewGrid;

import java.util.ArrayList;

public class GameScreen extends Pane {

    private Text goldText = new Text("GOLD");
    private Text healthText = new Text("HEALTH");
    private Text attackText = new Text("ATTACK");
    private ImageViewGrid equipGrid;
    private ImageViewGrid roomGrid;
    private ImageViewGrid gameObjectGrid;
    private ImageViewGrid inventoryGrid;
    private TileSet currentTileSet = new OutsideTileSet();

    static final int ROWS = 18;
    static final int COLUMNS = 24;
    static final int DIMENSIONS = 50;


    public GameScreen() {
        super();
        goldText.setX(10);
        goldText.setY(30);

        healthText.setX(10);
        healthText.setY(50);

        attackText.setX(10);
        attackText.setY(70);

        equipGrid = new ImageViewGrid(1, 2, DIMENSIONS);
        inventoryGrid = new ImageViewGrid(1, Inventory.INVENTORY_SIZE, DIMENSIONS);

        inventoryGrid.setTranslateY(800);
        equipGrid.setTranslateY(850);
        roomGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        gameObjectGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        this.getChildren().addAll(roomGrid, gameObjectGrid, inventoryGrid, equipGrid, goldText, healthText, attackText);
    }

    public void updateRoomGrid(Room.RoomCellType[][] map) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                Image tile;
                tile = currentTileSet.getTileImage(map[r][c]);
                roomGrid.setImage(tile, r, c);
            }
        }
    }

    public void updateGameObjectGrid(ArrayList<GameObject> gameObjects) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                gameObjectGrid.setImage(null, r, c);
            }
        }
        for (GameObject go: gameObjects) {
            gameObjectGrid.setImage(go.getSprite(),
                    go.getPosition().getRow(), go.getPosition().getCol());
        }
    }

    public void updateInventoryGrid() {
        ArrayList<Item> inventory = GameState.getInstance().getInventory().getItems();

        for (int c = 0; c < Inventory.INVENTORY_SIZE; c++) {
            inventoryGrid.setImage(null, 0, c);
        }

        for (int i = 0; i < inventory.size(); i++) {
            inventoryGrid.setImage(inventory.get(i).getSprite(), 0, i);
        }
    }

    public void updateEquipGrid() {
        equipGrid.setImage(null, 0, 0);
        equipGrid.setImage(null, 0, 1);

        if (GameState.getInstance().getUsedItem() != null) {
            equipGrid.setImage(GameState.getInstance().getUsedItem().getSprite(), 0, 1);
        }

        equipGrid.setImage(GameState.getInstance().getPlayer().getWeapon().getSprite(), 0, 0);
    }

    public void setHealth(int health) {
        healthText.setText("HEALTH: " + health);
    }

    public void setGold(int gold) {
        goldText.setText("GOLD: " + gold);
    }

    public void setAttack(int attack) {
        attackText.setText("ATTACK: " + attack);
    }
}
