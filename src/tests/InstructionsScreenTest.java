import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.InstructScreenController;

import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class InstructionsScreenTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        InstructScreenController controller = new InstructScreenController(stage);
        controller.initInstructScreen();
    }
    @Test
    public void testInstructions() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickOn("Menu");
        TimeUnit.SECONDS.sleep(1);
        verifyThat("Play", NodeMatchers.isNotNull());
    }
}
