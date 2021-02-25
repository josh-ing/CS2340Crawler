package quack.models;

public class Room {

    public enum RoomCellType {
        FLOOR, //0
        WALL, //1
        CHEST, //2
        NORTH, //3
        SOUTH, //4
        EAST, //5
        WEST //6
    }

    public enum RoomType {
        TREASURE,
        SHOP,
        MONSTER,
        BOSS
    }

    public enum TileSetType {
        GRASSY,
        FOREST,
        DUNGEON
    }

    private RoomType type;
    private RoomCellType[][] map;
    private Room[] neighbors; //[NORTH, SOUTH, EAST, WEST]
    private TileSetType tileSet;

    public Room(RoomCellType[][] map, RoomType type, Room[] neighbors, TileSetType tileSet) {
        this.type = type;
        this.map = map;
        this.neighbors = neighbors;
        this.tileSet = tileSet;
    }

    public Room(int[][] intMap, RoomType type, Room[] neighbors, TileSetType tileSet) {
        this(createMapFromIntArray(intMap), type, neighbors, tileSet);
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

    public TileSetType getTileSet() {
        return tileSet;
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

    public void setTileSet(TileSetType tileSet) {
        this.tileSet = tileSet;
    }

    public static RoomCellType[][] createMapFromIntArray(int[][] intMap) {
        RoomCellType[][] map = new RoomCellType[intMap.length][intMap[0].length];

        for (int i = 0; i < intMap.length; i++) {
            for (int j = 0; j < intMap[0].length; j++) {
                map[i][j] = RoomCellType.values()[intMap[j][i]];
            }
        }

        return map;
    }
}
