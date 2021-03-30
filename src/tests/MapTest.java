import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.testfx.framework.junit.ApplicationTest;
import quack.models.Room;
import quack.models.RoomGenerator;

public class MapTest extends ApplicationTest {
    private RoomGenerator layout;
    private Room test;


    @Override
    public void start(Stage stage) throws Exception {
        layout = new RoomGenerator(7, 24, 18);
        test = layout.generateStartRoom();
    }

    @Test
    public void testStartRoomType() throws Exception {
        Assert.assertEquals(Room.RoomType.START, test.getRoomType());
    }

    @Test
    public void testNeighborsNull() throws Exception {
        Room[] neighbors = test.getNeighbors();
        Room test2 = neighbors[3];
        Room[] test3 = test2.getNeighbors();
        int size = 0;
        for (int i = 0; i < test3.length; i++) {
            if (test3[i] != null) {
                size++;
            }
        }
        Assert.assertEquals(1, size);
    }
}