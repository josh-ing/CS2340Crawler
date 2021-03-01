import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.MainMenuController;


import static org.testfx.api.FxAssert.verifyThat;

public class ConfigControllerTest extends ApplicationTest{
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        MainMenuController controller = new MainMenuController(stage);
        controller.initMainMenu();
    }

    @Test
    public void testNameEmptyField() {
        clickOn("Play");
        write("");
        clickOn("Easy");
        clickOn("Toaster Bow");
        clickOn("Quack");
        clickOn("Start Game");
        verifyThat("You cannot have null values.", NodeMatchers.isVisible());
        clickOn("OK");
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
    public void testNameNullField() {
        clickOn("Play");
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
