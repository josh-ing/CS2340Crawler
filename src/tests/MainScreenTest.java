
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.MainMenuController;

import static org.testfx.api.FxAssert.verifyThat;

public class MainScreenTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        MainMenuController controller = new MainMenuController(stage);
        controller.initMainMenu();
    }

    @Test
    public void testPlayButton() {
        verifyThat("Play", NodeMatchers.isNotNull());
    }
}
