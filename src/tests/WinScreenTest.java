
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.WinScreenController;
import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class WinScreenTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        WinScreenController controller = new WinScreenController(stage);
        controller.initWin();
    }

    @Test
    public void testPlayAgainButton() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        verifyThat("Play Again!", NodeMatchers.isNotNull());
    }

    @Test
    public void testMenuReturn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickOn("Play Again!");
        TimeUnit.SECONDS.sleep(1);
        verifyThat("Play", NodeMatchers.isNotNull());
    }

    @Test
    public void testInitReplay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickOn("Play Again!");
        TimeUnit.SECONDS.sleep(1);
        clickOn("Play");
        write("Quacky");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 100", NodeMatchers.isNotNull());
    }
}
