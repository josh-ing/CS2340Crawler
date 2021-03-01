import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.MainMenuController;
import quack.views.ConfigScreen;

import static org.testfx.api.FxAssert.verifyThat;
import java.util.concurrent.TimeUnit;

public class ConfigControllerTest extends ApplicationTest {
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
    public void testAllSpacesNameField() {
        clickOn("Play");
        write("     ");
        clickOn("Easy");
        clickOn("Toaster Bow");
        clickOn("Quack");
        clickOn("Start Game");
        verifyThat("You cannot have null values.", NodeMatchers.isVisible());
        clickOn("OK");
    }

    @Test
    public void testEmptyDifficultyField() {
        clickOn("Play");
        write("  Joe  ");
        clickOn("Toaster Bow");
        clickOn("Quack");
        clickOn("Start Game");
        verifyThat("You cannot have null values.", NodeMatchers.isVisible());
        clickOn("OK");
    }

    @Test
    public void testEmptyWeaponField() {
        clickOn("Play");
        write("  Joe  ");
        clickOn("Easy");
        clickOn("Quack");
        clickOn("Start Game");
        verifyThat("You cannot have null values.", NodeMatchers.isVisible());
        clickOn("OK");
    }

    @Test
    public void testEmptyCharacterField() {
        clickOn("Play");
        write("  Joe  ");
        clickOn("Easy");
        clickOn("Toaster Bow");
        clickOn("Start Game");
        verifyThat("You cannot have null values.", NodeMatchers.isVisible());
        clickOn("OK");
    }

    @Test
    public void testEasyConfig() throws Exception {
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Easy");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 100", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumConfig() throws Exception {
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Medium");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 50", NodeMatchers.isNotNull());
    }

    @Test
    public void testHardConfig() throws Exception {
        clickOn("Play");
        TimeUnit.SECONDS.sleep(1);
        write("Sample Text");
        clickOn("Hard");
        clickOn("Wand");
        clickOn("Henry");
        clickOn("Start Game");
        verifyThat("Gold: 0", NodeMatchers.isNotNull());
    }
}
