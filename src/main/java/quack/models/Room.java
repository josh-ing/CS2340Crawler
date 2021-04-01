package quack.models;

import quack.models.tilesets.TileSet;

import java.util.ArrayList;

public class Room {

    public enum RoomCellType {
        FLOOR,
        WALL,
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public enum RoomType {
        START,
        TREASURE,
        SHOP,
        MONSTER,
        BOSS,
        EXIT,
    }

    private RoomType type;
    private RoomCellType[][] map;
    private Room[] neighbors; //[NORTH, EAST, SOUTH, WEST]
    private TileSet tileSet;
    private ArrayList<GameObject> gameObjects;

    public Room(RoomCellType[][] map, RoomType type, Room[] neighbors, TileSet tileSet) {
        this.type = type;
        this.map = map;
        this.neighbors = neighbors;
        this.tileSet = tileSet;
        this.gameObjects = new ArrayList<>();
    }

    public Room(RoomCellType[][] map, RoomType type) {
        this.type = type;
        this.map = map;
        this.neighbors = new Room[4];
        this.gameObjects = new ArrayList<>();
    }

    public Room(int[][] intMap, RoomType type, Room[] neighbors) {
        this(createMapFromIntArray(intMap), type, neighbors, null);
    }

    public Room(int[][] intMap, RoomType type) {
        this(createMapFromIntArray(intMap), type);
    }

    public RoomType getRoomType() {
        return type;
    }

    public RoomCellType[][] getMap() {
        return map;
    }

    public Room[] getNeighbors() {
        return neighbors;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setMap(RoomCellType[][] map) {
        this.map = map;
    }

    public void setNeighbors(Room[] neighbors) {
        this.neighbors = neighbors;
    }


    public static RoomCellType[][] createMapFromIntArray(int[][] intMap) {
        RoomCellType[][] map = new RoomCellType[intMap.length][intMap[0].length];

        for (int i = 0; i < intMap.length; i++) {
            for (int j = 0; j < intMap[i].length; j++) {
                map[i][j] = RoomCellType.values()[intMap[i][j]];
            }
        }

        return map;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public boolean isValidPosition(int row, int col) {
        for (GameObject go: GameState.getInstance().getCurrentRoom().getGameObjects()) {
            if (row == go.getRow() && col == go.getCol()) {
                return false;
            }
        }
        if (row > map.length - 1 || col > map[0].length - 1 || row < 0 || col < 0) {
            return false;
        }
        if (map[row][col] == RoomCellType.WALL) {
            return false;
        }
        return true;
    }
}
