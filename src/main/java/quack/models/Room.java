package quack.models;

public class Room {

    public enum RoomCellType {
        FLOOR, //0
        WALL, //1
        CHEST, //2
        NORTH, //3
        EAST, //4
        SOUTH, //5
        WEST //6
    }

    public enum RoomType {
        START,
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
    private Room[] neighbors; //[NORTH, EAST, SOUTH, WEST]
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
        RoomCellType[][] map = new RoomCellType[intMap[0].length][intMap.length];

        for (int i = 0; i < intMap.length; i++) {
            for (int j = 0; j < intMap[i].length; j++) {
                map[j][i] = RoomCellType.values()[intMap[i][j]];
            }
        }

        return map;
    }
}
