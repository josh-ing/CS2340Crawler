import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.LoseScreenController;

import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class EndGameTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        LoseScreenController controller = new LoseScreenController(stage);
        controller.initLose();
    }
    @Test
    public void testEndStatsWin() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Monsters Killed: ");
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Damage Dealt: ");
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Gold Earned: ");
        clickOn("Play Again!");
        verifyThat("Play", NodeMatchers.isNotNull());
    }
    @Test
    public void testStatsLose() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Monsters Killed: ");
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Damage Dealt: ");
        TimeUnit.SECONDS.sleep(1);
        clickOn("Total Gold Earned: ");
        clickOn("Play Again!");
        verifyThat("Play", NodeMatchers.isNotNull());
    }
}
