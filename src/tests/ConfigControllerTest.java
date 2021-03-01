import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import javafx.scene.control.Alert;
import quack.controllers.ConfigController;
import quack.controllers.Controller;
import quack.controllers.MainMenuController;
import quack.models.PlayerModel;
import quack.models.characters.PlayableCharacterModel;
import quack.views.ConfigScreen;

import java.io.FileNotFoundException;

import static org.testfx.api.FxAssert.verifyThat;

public class ConfigControllerTest extends ApplicationTest{
    private ConfigScreen configure;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuController mainMenuController = new MainMenuController(primaryStage);
        mainMenuController.initMainMenu();
    }

    @Test
    public void testPlay() {
        clickOn("Play");
        verifyThat("Choose your character!", NodeMatchers.isNotNull());
    }

    @Test
    public void testEasyConfig() {
        clickOn("Play");
        write("Sample Text");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 100", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumConfig() {
        clickOn("Play");
        write("Sample Text");
        clickOn("Medium");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 50", NodeMatchers.isNotNull());
    }

    @Test
    public void testHardConfig() {
        clickOn("Play");
        write("Sample Text");
        clickOn("Hard");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 0", NodeMatchers.isNotNull());
    }
}
