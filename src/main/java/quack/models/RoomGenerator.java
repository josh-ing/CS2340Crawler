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
    static final int NUM_CHALLENGE = 2;

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
    private Room.RoomCellType[][] createRoomTemplate() {
        Room.RoomCellType[][] roomTemplate = new Room.RoomCellType[mapHeight][mapWidth];

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                roomTemplate[i][j] = Room.RoomCellType.FLOOR;
            }
        }

        //Initialize vertical wall borders
        for (int i = 0; i < mapHeight; i++) {
            roomTemplate[i][0] = Room.RoomCellType.LEFT_WALL;
            roomTemplate[i][mapWidth - 1] = Room.RoomCellType.RIGHT_WALL;
        }
        //Initialize horizontal wall borders
        for (int i = 0; i < mapWidth; i++) {
            roomTemplate[0][i] = Room.RoomCellType.UP_WALL;
            roomTemplate[mapHeight - 1][i] = Room.RoomCellType.DOWN_WALL;
        }

        roomTemplate[0][0] = Room.RoomCellType.UL_WALL;
        roomTemplate[0][roomTemplate[0].length - 1] = Room.RoomCellType.UR_WALL;
        roomTemplate[roomTemplate.length - 1]
                [roomTemplate[0].length - 1] = Room.RoomCellType.LR_WALL;
        roomTemplate[roomTemplate.length - 1][0] = Room.RoomCellType.LL_WALL;

        return roomTemplate;
    }

    /**
     * Creates a random room layout with obstacles.
     * @return A 2d int array representing a random room.
     */
    private Room.RoomCellType[][] createRandomRoom() {
        Random rand = new Random();
        Room.RoomCellType[][] randomRoom = createRoomTemplate();
        for (int i = 0; i < NUM_OBSTACLES; i++) {
            int row = CLEARANCE + rand.nextInt(mapHeight - 1 - 2 * CLEARANCE);
            int col = CLEARANCE + rand.nextInt(mapWidth - 1 - 2 * CLEARANCE);
            int coinFlip = rand.nextInt(2);
            randomRoom[row][col] = Room.RoomCellType.OBSTRUCTION;
            if (coinFlip == 0) {
                randomRoom[row + 1][col] = Room.RoomCellType.OBSTRUCTION;
            } else {
                randomRoom[row][col - 1] = Room.RoomCellType.OBSTRUCTION;
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
        Room.RoomCellType[][] startRoomArray = createRoomTemplate();
        Room startRoom = new Room(startRoomArray, Room.RoomType.START, null);
        Room[] startRoomNeighbors = new Room[4];

        //Note that one of these four rooms will be overrided with the path to the boss room.
        for (int i = 0; i < 4; i++) {
            Room[] newRoomNeighbors = new Room[4];
            newRoomNeighbors[(i + 2) % 4] = startRoom;
            Room newRoom = new Room(createRoomTemplate(), Room.RoomType.TREASURE,
                    newRoomNeighbors);
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



            Room.RoomCellType[][] roomArray = createRandomRoom();

            if (3 == i || 5 == i) {
                int direction = directionsTowardsExit.get(rand.nextInt(directionsTowardsExit.size()));
                Room challengeRoom = new Room(createRoomTemplate(), Room.RoomType.CHALLENGE);
                connectRooms(currentRoom, challengeRoom, direction);

                //directionsTowardsExit.remove(direction % directionsTowardsExit.size());

                directionsTowardsExit.remove((Integer) (direction % 4));

            }

            int direction = directionsTowardsExit.get(rand.nextInt(directionsTowardsExit.size()));

            Room newRoom = new Room(roomArray, Room.RoomType.MONSTER);
            connectRooms(currentRoom, newRoom, direction);

            lastExit = direction;
            currentRoom = newRoom;

        }
        addBossRoom(currentRoom, lastExit);
        return newStartRoom;
    }

    public void connectRooms(Room currentRoom, Room newRoom, int direction) {
        Room[] currentRoomNeighbors = currentRoom.getNeighbors();
        Room[] newRoomNeighbors = newRoom.getNeighbors();
        currentRoomNeighbors[direction] = newRoom;
        newRoomNeighbors[(direction + 2) % 4] = currentRoom;
        currentRoom.setNeighbors(currentRoomNeighbors);
        newRoom.setNeighbors(newRoomNeighbors);
        currentRoom.setMap(addExitsToRoomArray(currentRoom));
        newRoom.setMap(addExitsToRoomArray(newRoom));
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
                Room.RoomType.EXIT);
        Room[] bossRoomNeighbors = new Room[4];
        bossRoomNeighbors[(lastExit + 2) % 4] = lastRoom;
        bossRoomNeighbors[lastExit] = exitRoom;
        Room bossRoom = new Room(createRoomTemplate(),
                Room.RoomType.BOSS, bossRoomNeighbors);
        lastRoomNeighbors[lastExit] = bossRoom;
        lastRoom.setNeighbors(lastRoomNeighbors);
        addExitsToRoomArray(lastRoom);
        addExitsToRoomArray(bossRoom);
    }

}
