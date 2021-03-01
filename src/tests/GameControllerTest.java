import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.MainMenuController;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javafx.scene.Node;

import static org.testfx.api.FxAssert.verifyThat;

public class GameControllerTest extends ApplicationTest {

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        MainMenuController mainMenuController = new MainMenuController(stage);
        mainMenuController.initMainMenu();
    }

    @Test
    public void testNorthExitVisible() throws Exception{
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        TimeUnit.SECONDS.sleep(2);
        Set<Node> tiles = lookup("NORTH").queryAll();
        Assert.assertEquals(2, tiles.size());
        for (Node node : tiles) {
            clickOn(node);
        }
        verifyThat("NORTH", NodeMatchers.isNotNull());
    }
    @Test
    public void testSouthExitVisible() throws Exception{
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        TimeUnit.SECONDS.sleep(2);
        Set<Node> tiles = lookup("SOUTH").queryAll();
        Assert.assertEquals(2, tiles.size());
        for (Node node : tiles) {
            clickOn(node);
        }
        verifyThat("SOUTH", NodeMatchers.isNotNull());
    }


    @Test
    public void testWallsVisible() throws Exception{
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        TimeUnit.SECONDS.sleep(2);
        Set<Node> tiles = lookup("WALL").queryAll();
        Assert.assertEquals(105, tiles.size());
        for (Node node : tiles) {
            clickOn(node);
        }
        verifyThat("WALL", NodeMatchers.isNotNull());
    }

}
