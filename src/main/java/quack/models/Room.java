package quack.models;

import quack.models.items.Chest;
import quack.models.items.DroppedItem;
import quack.models.monsters.*;
import quack.models.tilesets.OutsideTileSet;
import quack.models.tilesets.TileSet;
import java.util.Random;

import java.util.ArrayList;

public class Room {

    public enum RoomCellType {
        FLOOR,
        RIGHT_WALL,
        DOWN_WALL,
        LEFT_WALL,
        UP_WALL,
        UL_WALL,
        UR_WALL,
        LL_WALL,
        LR_WALL,
        OBSTRUCTION,
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public enum RoomType {
        START,
        TREASURE,
        CHALLENGE,
        MONSTER,
        BOSS,
        EXIT,
    }

    private RoomType type;
    private RoomCellType[][] map;
    private Room[] neighbors; //[NORTH, EAST, SOUTH, WEST]
    private TileSet tileSet;
    private ArrayList<GameObject> gameObjects;
    private Random random = new Random();


    public Room(RoomCellType[][] map, RoomType type, Room[] neighbors, TileSet tileSet) {
        this.type = type;
        this.map = map;
        this.neighbors = neighbors;
        this.tileSet = tileSet;
        this.gameObjects = new ArrayList<>();
        if (type == RoomType.CHALLENGE) {
            Monster monster = new ChallengeTotem();
            monster.setPosition(new Position(9, 12));
            addGameObject(monster);
        }else if (type != RoomType.START) {
            spawnMonsters(3, 1, 1);
            Chest chest = new Chest();
            ArrayList<Position> validPositions = getValidPositions();
            chest.setPosition(validPositions.get(random.nextInt(validPositions.size())));

            addGameObject(chest);
        }

    }

    public void spawnMonsters(int numEasy, int numMed, int numHard) {

        for (int i = 0; i < numEasy; i++) {
            Monster monster = new EasyMonster();
            ArrayList<Position> validPositions = getValidPositions();
            monster.setPosition(validPositions.get(random.nextInt(validPositions.size())));

            addGameObject(monster);
        }

        for (int i = 0; i < numMed; i++) {
            Monster monster = new MediumMonster();
            ArrayList<Position> validPositions = getValidPositions();
            monster.setPosition(validPositions.get(random.nextInt(validPositions.size())));

            addGameObject(monster);
        }

        for (int i = 0; i < numHard; i++) {
            Monster monster = new HardMonster();
            ArrayList<Position> validPositions = getValidPositions();
            monster.setPosition(validPositions.get(random.nextInt(validPositions.size())));

            addGameObject(monster);
        }


    }

    public Room(RoomCellType[][] map, RoomType type) {
        this(map, type, new Room[4], new OutsideTileSet());
    }

    public Room(RoomCellType[][] map, RoomType type, Room[] neighbors) {
        this(map, type, neighbors, null);
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

    public boolean isValidPosition(Position position) {
        for (GameObject go : GameState.getInstance().getCurrentRoom().getGameObjects()) {
            if (position.getRow() == go.getPosition().getRow()
                    && position.getCol() == go.getPosition().getCol()
                    && !(go instanceof DroppedItem)) {
                return false;
            }
        }

        if (position.getRow() > map.length - 1 || position.getCol() > map[0].length - 1
                || position.getRow() < 0 || position.getCol() < 0) {
            return false;
        }

        switch (map[position.getRow()][position.getCol()]) {
        case FLOOR:
        case NORTH:
        case SOUTH:
        case EAST:
        case WEST:
            return true;
        default:
            return false;
        }
    }

    public Position getExitPosition(RoomCellType exit) {
        Position position = null;

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == exit) {
                    position = new Position(r, c);
                    break;
                }
            }
        }

        return position;
    }

    public ArrayList<Position> getValidPositions() {
        ArrayList<Position> positions = new ArrayList<>();
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == RoomCellType.FLOOR) {
                    Position position = new Position(r, c);

                    if (position.translateUp().equals(getExitPosition(RoomCellType.NORTH))) {
                        continue;
                    }

                    if (position.translateDown().equals(getExitPosition(RoomCellType.SOUTH))) {
                        continue;
                    }

                    if (position.translateRight().equals(getExitPosition(RoomCellType.EAST))) {
                        continue;
                    }

                    if (position.translateLeft().equals(getExitPosition(RoomCellType.WEST))) {
                        continue;
                    }

                    positions.add(position);
                }
            }
        }

        return positions;
    }

    public GameObject getGameObjectAtPosition(Position position) {
        for (GameObject go : gameObjects) {
            if (position.equals(go.getPosition())) {
                return go;
            }
        }

        return null;
    }

    public boolean isEmptyOfMonsters() {
        if (type == RoomType.CHALLENGE) {
            for (GameObject go : gameObjects) {
                if (go instanceof ChallengeTotem) {
                    return true;
                }
                if (go instanceof HardMonster) {
                    return false;
                }
            }
        }
        for (GameObject go : gameObjects) {
            if (go instanceof Monster) {
                return false;
            }
        }

        return true;
    }
}
