import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quack.models.Map;
import quack.models.Room;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MapTest {

    private Map map;

    public static void printRoom(Room.RoomCellType[][] roomLayout) {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 24; j++) {
                System.out.print(roomLayout[i][j].ordinal());
            }
            System.out.println();
        }
    }

    public static int countRooms(Map map) {
        Room currRoom = map.generateMap();
        LinkedList<Room> queue = new LinkedList<>();
        HashSet<Room> visited = new HashSet<>();
        queue.addLast(currRoom);

        int count = 0;

        while (!queue.isEmpty()) {

            Room room = queue.removeFirst();
            visited.add(room);
            for (Room r: room.getNeighbors()) {
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
        map = new Map(0, 24, 17);
        assertEquals(6, countRooms(map));

        map = new Map(3, 24, 17);
        assertEquals(9, countRooms(map));

        map = new Map(7, 24, 17);
        assertEquals(13, countRooms(map));
    }

    @Test
    public void testStartRoomNeighbors() {
        map = new Map(0, 24, 17);
        Room startRoom = map.generateMap();
        assertEquals(4, startRoom.getNeighbors().length);

        map = new Map(4, 24, 17);
        startRoom = map.generateMap();
        assertEquals(4, startRoom.getNeighbors().length);

        map = new Map(7, 24, 17);
        startRoom = map.generateMap();
        assertEquals(4, startRoom.getNeighbors().length);

    }
}
