package quack.controllers;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quack.views.GameScreen;
import quack.models.Room;
import quack.models.PlayerModel;
import quack.models.RoomGenerator;
import javafx.concurrent.Task;

import java.time.Duration;

/**
 * Controller for MainMenuScreen
 */
public class GameController extends Controller {
    private RoomGenerator roomGenerator;
    private GameScreen gameScreen;
    private Room currentRoom;
    private PlayerModel player;
    private KeyEvent currentAction;

    /**
     * Initializes the controller with a stage.
     * @param stage The stage involved with the game controller.
     */
    public GameController(Stage stage) {
        super(stage);
    }

    /**
     * Initializes app to show map.
     * @param roomGenerator The randomly generated map.
     * @param player The player model chosen.
     */
    public void initGame(RoomGenerator roomGenerator, PlayerModel player) {
        this.roomGenerator = roomGenerator;
        this.player = player;

        Room start = roomGenerator.generateStartRoom();
        this.currentRoom = start;

        gameScreen = new GameScreen(start, player);
        gameScreen.setMinWidth(1200);
        gameScreen.setMinHeight(900);
        gameScreen.getGoldText().setText("Gold: " + player.getGold());

        this.stage.setScene(new Scene(gameScreen));

        this.stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> processInput(key));
    }

    private void setGameScreenRoom(Room room) {
        if (room.getRoomType() == Room.RoomType.EXIT) {
            WinScreenController winScreenController = new WinScreenController(stage);
            winScreenController.initWin();
        } else {
            this.currentRoom = room;
            gameScreen.setRoom(room);
            gameScreen.render();
            gameScreen.getGoldText().setText("Gold: " + player.getGold());
        }
    }

    private void processInput(KeyEvent key) {
        this.currentAction = key;
        update();
        render();
    }

    private void update() {
        if (this.currentAction != null) {

            System.out.println(this.currentAction);

            switch (this.currentAction.getCode()) {
                case UP:
                    if (isValidPosition(player.getX(), player.getY() - 1)) {
                        player.setY(player.getY() - 1);
                    }
                    break;

                case DOWN:
                    if (isValidPosition(player.getX(), player.getY() + 1)) {
                        player.setY(player.getY() + 1);
                    }
                    break;

                case LEFT:
                    if (isValidPosition(player.getX() - 1, player.getY())) {
                        player.setX(player.getX() - 1);
                    }
                    break;

                case RIGHT:
                    if (isValidPosition(player.getX() + 1, player.getY())) {
                        player.setX(player.getX() + 1);
                    }
                    break;
            }

            this.currentAction = null;
        }
    }

    private boolean isValidPosition(int x, int y) {
        return (currentRoom.getMap()[y][x] != Room.RoomCellType.WALL);
    }

    private void render() {
        gameScreen.render();
    }

    public void changeRoom(KeyEvent key) {
//        Room[] neighbors = currentRoom.getNeighbors();
//        System.out.println(Arrays.toString(neighbors));
//
//        switch(key.getCode()) {
//            case UP:
//                if (neighbors[0] != null) {
//                    setGameScreenRoom(neighbors[0]);
//                }
//                break;
//
//            case RIGHT:
//                if (neighbors[1] != null) {
//                    setGameScreenRoom(neighbors[1]);
//                }
//                break;
//
//            case DOWN:
//                if (neighbors[2] != null) {
//                    setGameScreenRoom(neighbors[2]);
//                }
//                break;
//
//            case LEFT:
//                if (neighbors[3] != null) {
//                    setGameScreenRoom(neighbors[3]);
//                }
//                break;
//        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
