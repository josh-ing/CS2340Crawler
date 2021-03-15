package quack.models;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents map creation and generation.
 * mapGeneration should be used to receive a random map.
 */
public class RoomGenerator {

    private int mapHeight;
    private int mapWidth;
    private int roomsToBoss;

    static final int CLEARANCE = 5;
    static final int NUM_OBSTACLES = 4;

    /**
     * Initialize the configuration for map generation.
     * @param roomsToBoss The length of the shortest path from the
     * start room to the boss room. This does not represent the total amount of rooms.
     * @param mapWidth Width of the map (amount of columns)
     * @param mapHeight Height of the map (amount of rows)
     */
    public RoomGenerator(int roomsToBoss, int mapWidth, int mapHeight) {
        this.roomsToBoss = roomsToBoss;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
    }

    /**
     * Creates a int array where the border are all 1s.
     * @return 2d int array representing the room.
     */
    private int[][] createRoomTemplate() {
        int[][] roomTemplate = new int[mapHeight][mapWidth];

        //Initialize vertical wall borders
        for (int i = 0; i < mapHeight; i++) {
            roomTemplate[i][0] = 1;
            roomTemplate[i][mapWidth - 1] = 1;
        }
        //Initialize horizontal wall borders
        for (int i = 0; i < mapWidth; i++) {
            roomTemplate[0][i] = 1;
            roomTemplate[mapHeight - 1][i] = 1;
        }

        return roomTemplate;
    }

    /**
     * Creates a random room layout with obstacles.
     * @return A 2d int array representing a random room.
     */
    private int[][] createRandomRoom() {
        Random rand = new Random();
        int[][] randomRoom = createRoomTemplate();
        for (int i = 0; i < NUM_OBSTACLES; i++) {
            int row = CLEARANCE + rand.nextInt(mapHeight - 1 - 2 * CLEARANCE);
            int col = CLEARANCE + rand.nextInt(mapWidth - 1 - 2 * CLEARANCE);
            int coinFlip = rand.nextInt(2);
            randomRoom[row][col] = 1;
            if (coinFlip == 0) {
                randomRoom[row + 1][col] = 1;
            } else {
                randomRoom[row][col - 1] = 1;
            }
        }

        return randomRoom;
    }

    /**
     * Creates a start room with four exits. All exits are defaulted to treasure rooms.
     * One of these rooms will be overrided in generateMap as the path towards the boss room.
     * @return Room representing the start room.
     */
    private Room createStartRoom() {
        int[][] startRoomArray = createRoomTemplate();
        Room startRoom = new Room(startRoomArray, Room.RoomType.START, Room.TileSetType.DUNGEON);
        Room[] startRoomNeighbors = new Room[4];

        //Note that one of these four rooms will be overrided with the path to the boss room.
        for (int i = 0; i < 4; i++) {
            Room[] newRoomNeighbors = new Room[4];
            newRoomNeighbors[(i + 2) % 4] = startRoom;
            Room newRoom = new Room(createRoomTemplate(), Room.RoomType.TREASURE,
                    newRoomNeighbors, Room.TileSetType.DUNGEON);
            addExitsToRoomArray(newRoom);
            startRoomNeighbors[i] = newRoom;

        }
        startRoom.setNeighbors(startRoomNeighbors);
        return startRoom;
    }

    /**
     * This method returns the start room for the map.
     * Any navigation should start from the start room.
     * @return Room object representing the start room.
     */
    public Room generateStartRoom() {

        Random rand = new Random();

        Room newStartRoom = createStartRoom();

        Room currentRoom = newStartRoom;

        int lastExit = 2;

        for (int i = 0; i < roomsToBoss; i++) {

            ArrayList<Integer> directionsTowardsExit = new ArrayList<>();
            for (int d = 0; d < 4; d++) {
                directionsTowardsExit.add(d);
            }

            directionsTowardsExit.remove((lastExit + 2) % 4);

            int[][] roomArray = createRandomRoom();
            int direction = directionsTowardsExit.get(rand.nextInt(3));

            Room[] currentRoomNeighbors = currentRoom.getNeighbors();
            Room[] newRoomNeighbors = new Room[4];
            Room newRoom = new Room(roomArray, Room.RoomType.MONSTER, Room.TileSetType.DUNGEON);
            currentRoomNeighbors[direction] = newRoom;
            newRoomNeighbors[(direction + 2) % 4] = currentRoom;
            currentRoom.setNeighbors(currentRoomNeighbors);
            newRoom.setNeighbors(newRoomNeighbors);
            currentRoom.setMap(addExitsToRoomArray(currentRoom));
            newRoom.setMap(addExitsToRoomArray(newRoom));
            lastExit = direction;
            currentRoom = newRoom;

        }
        addBossRoom(currentRoom, lastExit);
        return newStartRoom;
    }

    /**
     * @param room The room to add exits to
     * @return 2d RoomCellType array representing room.
     */
    private Room.RoomCellType[][] addExitsToRoomArray(Room room) {
        Room.RoomCellType[][] roomArray = room.getMap();

        for (int exit = 0; exit < 4; exit++) {
            if (room.getNeighbors()[exit] != null) {
                if (exit == 0) {
                    roomArray[0][mapWidth / 2] = Room.RoomCellType.NORTH;
                } else if (exit == 1) {
                    roomArray[mapHeight / 2][mapWidth - 1] = Room.RoomCellType.EAST;
                }  else if (exit == 2) {
                    roomArray[mapHeight - 1][mapWidth / 2] = Room.RoomCellType.SOUTH;
                } else if (exit == 3) {
                    roomArray[mapHeight / 2][0] = Room.RoomCellType.WEST;
                }
            }
        }
        return roomArray;
    }

    /**
     * Adds the boss room.
     * @param lastRoom The room before the boss room.
     * @param lastExit The the exit portal connected to the last room.
     */
    private void addBossRoom(Room lastRoom, int lastExit) {
        Room[] lastRoomNeighbors = lastRoom.getNeighbors();
        Room exitRoom = new Room(createRoomTemplate(),
                Room.RoomType.EXIT, Room.TileSetType.DUNGEON);
        Room[] bossRoomNeighbors = new Room[4];
        bossRoomNeighbors[(lastExit + 2) % 4] = lastRoom;
        bossRoomNeighbors[lastExit] = exitRoom;
        Room bossRoom = new Room(createRoomTemplate(),
                Room.RoomType.BOSS, bossRoomNeighbors, Room.TileSetType.DUNGEON);
        lastRoomNeighbors[lastExit] = bossRoom;
        lastRoom.setNeighbors(lastRoomNeighbors);
        addExitsToRoomArray(lastRoom);
        addExitsToRoomArray(bossRoom);
    }

}
