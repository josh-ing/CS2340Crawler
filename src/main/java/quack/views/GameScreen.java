package quack.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Room;
import javafx.scene.text.Text;
import quack.models.items.Inventory;
import quack.models.items.InventoryHUD;
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
    private ImageViewGrid effectsGrid;
    private ImageViewGrid equipBlock;
    private ImageViewGrid inventoryBlock;
    private InventoryHUD hud;
    private TileSet currentTileSet = new OutsideTileSet();
    private Button menuButton;

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

        hud = new InventoryHUD();
        equipBlock = new ImageViewGrid(1, 2, DIMENSIONS);
        equipGrid = new ImageViewGrid(1, 2, DIMENSIONS);
        inventoryBlock = new ImageViewGrid(1, Inventory.INVENTORY_SIZE, DIMENSIONS);
        inventoryGrid = new ImageViewGrid(1, Inventory.INVENTORY_SIZE, DIMENSIONS);

        inventoryBlock.setTranslateY(800);
        inventoryGrid.setTranslateY(800);
        inventoryGrid.toFront();
        equipBlock.setTranslateY(850);
        equipGrid.setTranslateY(850);
        equipGrid.toFront();
        roomGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        gameObjectGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);
        effectsGrid = new ImageViewGrid(ROWS, COLUMNS, DIMENSIONS);

        Font font1;
        String fontFamily = "Tw Cen MT";
        FontWeight fontWeight = FontWeight.BOLD;
        double fontSize = 20;

        BackgroundFill backgroundFillBut = new BackgroundFill(Color.MOCCASIN,
            CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(backgroundFillBut);


        font1 = Font.font(fontFamily, fontWeight, fontSize);
        menuButton = new Button("Exit");
        menuButton.setBackground(background1);
        menuButton.setFont(font1);
        menuButton.setTranslateY(850);
        menuButton.setTranslateX(1130);
        menuButton.setBackground(background1);
        menuButton.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().addAll(roomGrid, gameObjectGrid, effectsGrid, inventoryBlock,
                inventoryGrid, equipBlock, equipGrid, goldText, healthText, attackText, menuButton);
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
            inventoryBlock.setImage(null, 0, c);
        }

        for (int i = 0; i < inventory.size(); i++) {
            inventoryGrid.setImage(inventory.get(i).getSprite(), 0, i);
            inventoryBlock.setImage(hud.getInventory(), 0, i);
            inventoryGrid.toFront();
        }
    }

    public void updateEquipGrid() {
        equipGrid.setImage(null, 0, 0);
        equipGrid.setImage(null, 0, 1);

        if (GameState.getInstance().getUsedItem() != null) {
            equipGrid.setImage(GameState.getInstance().getUsedItem().getSprite(), 0, 1);
            equipBlock.setImage(hud.getInventorySelect(), 0, 1);
            equipGrid.toFront();
        }

        equipGrid.setImage(GameState.getInstance().getPlayer().getWeapon().getSprite(), 0, 0);
        equipBlock.setImage(hud.getInventorySelect(), 0, 0);
        equipBlock.setImage(null, 0, 1);
        equipGrid.toFront();
    }

    public void updateEffectsGrid(ArrayList<GameObject> effectObjects) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                effectsGrid.setImage(null, r, c);
            }
        }

        for (GameObject eo: effectObjects) {
            effectsGrid.setImage(eo.getSprite(),
                    eo.getPosition().getRow(), eo.getPosition().getCol());
        }
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
    public Button getBackMenu() {
        return menuButton;
    }
    public void setBackMenu(Button newGameButton) {
        this.menuButton = menuButton;
    }
}
