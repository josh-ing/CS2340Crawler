package quack.models;

import java.util.ArrayList;

import java.util.Random;


public class Map {

    private ArrayList<Room> rooms;
    private int mapHeight;
    private int mapWidth;
    private int mapSize;

    private final int CLEARANCE = 5;
    private final int NUM_OBSTACLES = 4;

    public Map(int mapSize, int mapHeight, int mapWidth) {
        rooms = new ArrayList();
        this.mapSize = mapSize;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
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
            int row = CLEARANCE + rand.nextInt(mapWidth - 1 - CLEARANCE);
            int col = CLEARANCE + rand.nextInt(mapHeight - 1 - CLEARANCE);
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

    public Room[] generateRooms(){

        int[] directionsTowardsExit = new int[]{3, 4, 6};

        Random rand = new Random();

        for (int i = 0; i < mapSize; i++) {
            int[][] roomArray = createRoomTemplate();
            int direction = directionsTowardsExit[rand.nextInt(3)];
            if (direction == 3) {
                roomArray[mapWidth / 2][0] = 3;
            } else if (direction == 4) {
                roomArray[mapWidth - 1][mapHeight / 2] = 4;
            } else if (direction == 6) {
                roomArray[0][mapHeight / 2] = 6;
            }


            //Room room = new Room(roomArray, Room.RoomType.MONSTER, []);
        }




        return null;
    }

}
