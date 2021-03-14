package quack.models;
import java.util.Random;


public class Map {

    private Room startRoom;
    private int mapHeight;
    private int mapWidth;
    private int mapSize;

    private final int CLEARANCE = 5;
    private final int NUM_OBSTACLES = 4;

    public Map(int mapSize, int mapHeight, int mapWidth) {
        this.mapSize = mapSize;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.startRoom = generateMap();
    }


    /**
     * Creates a int array where the border are all 1s.
     * @return
     */
    private int[][] createRoomTemplate() {
        int [][] roomTemplate = new int[mapWidth][mapHeight];

        //Initialize wall borders
        for (int i = 0; i < mapHeight; i++) {
            roomTemplate[0][i] = 1;
            roomTemplate[mapWidth - 1][i] = 1;
        }
        for (int i = 0; i < mapWidth; i++) {
            roomTemplate[i][0] = 1;
            roomTemplate[i][mapHeight - 1] = 1;
        }

        return roomTemplate;
    }

    public int[][] createRandomRoom() {
        Random rand = new Random();
        int[][] randomRoom = createRoomTemplate();
        for (int i = 0; i < NUM_OBSTACLES; i++) {
            int row = CLEARANCE + rand.nextInt(mapWidth - 1 - 2 * CLEARANCE);
            int col = CLEARANCE + rand.nextInt(mapHeight - 1 - 2 * CLEARANCE);
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

    private Room createStartRoom() {
        int[][] startRoomArray = createRoomTemplate();
        startRoomArray[mapWidth / 2][0] = 3;
        startRoomArray[mapWidth - 1][mapHeight / 2] = 4;
        startRoomArray[mapWidth / 2][mapHeight - 1] = 5;
        startRoomArray[0][mapHeight / 2] = 6;
        Room[] neighbors = new Room[]{null, null, null, null};
        Room startRoom = new Room(startRoomArray, Room.RoomType.START, neighbors, Room.TileSetType.DUNGEON);
        return startRoom;

    }

    private Room generateMap(){

        int[] directionsTowardsExit = new int[]{3, 4, 6};

        Random rand = new Random();

        Room newStartRoom = createStartRoom();

        Room currentRoom = newStartRoom;

        for (int i = 0; i < mapSize; i++) {
            int[][] roomArray = createRandomRoom();
            int direction = directionsTowardsExit[rand.nextInt(3)];
            if (direction == 3) {
                roomArray[mapWidth / 2][0] = 3;
            } else if (direction == 4) {
                roomArray[mapWidth - 1][mapHeight / 2] = 4;
            } else if (direction == 6) {
                roomArray[0][mapHeight / 2] = 6;
            }
            Room[] currentRoomNeighbors = new Room[4];
            Room[] newRoomNeighbors = new Room[4];
            Room newRoom = new Room(roomArray, Room.RoomType.MONSTER, newRoomNeighbors, Room.TileSetType.DUNGEON);
            currentRoomNeighbors[direction - 3] = newRoom;
            currentRoom.setNeighbors(currentRoomNeighbors);
            currentRoom = newRoom;
        }


        return newStartRoom;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
