import org.junit.jupiter.api.Test;
import quack.models.Room;
import quack.models.RoomGenerator;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class RoomGeneratorTest {

    private RoomGenerator roomGenerator;

    public static void printRoom(Room.RoomCellType[][] roomLayout) {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 24; j++) {
                System.out.print(roomLayout[i][j].ordinal());
            }
            System.out.println();
        }
    }

    public static int countRooms(RoomGenerator map) {
        Room currRoom = map.generateStartRoom();
        LinkedList<Room> queue = new LinkedList<>();
        HashSet<Room> visited = new HashSet<>();
        queue.addLast(currRoom);

        int count = 0;

        while (!queue.isEmpty()) {

            Room room = queue.removeFirst();
            visited.add(room);
            for (Room r : room.getNeighbors()) {
                if (r != null && !visited.contains(r)) {
                    queue.addLast(r);
                }
            }
            count++;
        }
        return count;
    }

    @Test
    public void testTotalNumRooms() {
        roomGenerator = new RoomGenerator(0, 24, 17);
        assertEquals(6, countRooms(roomGenerator));

        roomGenerator = new RoomGenerator(3, 24, 17);
        assertEquals(9, countRooms(roomGenerator));

        roomGenerator = new RoomGenerator(7, 24, 17);
        assertEquals(13, countRooms(roomGenerator));
    }

    @Test
    public void testStartRoomNeighbors() {
        roomGenerator = new RoomGenerator(0, 24, 17);
        Room startRoom = roomGenerator.generateStartRoom();
        assertEquals(4, startRoom.getNeighbors().length);

        roomGenerator = new RoomGenerator(4, 24, 17);
        startRoom = roomGenerator.generateStartRoom();
        assertEquals(4, startRoom.getNeighbors().length);

        roomGenerator = new RoomGenerator(7, 24, 17);
        startRoom = roomGenerator.generateStartRoom();
        assertEquals(4, startRoom.getNeighbors().length);

    }

}
