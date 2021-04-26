
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.LoseScreenController;
import quack.models.Player;
import quack.models.characters.QuackCharacter;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.Weapon;

import java.util.concurrent.TimeUnit;

import static org.testfx.api.FxAssert.verifyThat;

public class LoseScreenTest extends ApplicationTest {
    private Player player;

    @Override
    public void start(Stage stage) throws Exception {
        LoseScreenController controller = new LoseScreenController(stage);
        controller.initLose();
    }

    @Test
    public void testPlayAgainButton() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        verifyThat("Play Again!", NodeMatchers.isNotNull());
    }

    @Test
    public void testMenuReturn() throws InterruptedException {
        Weapon weapon = new KnifeWeapon();
        QuackCharacter quack = new QuackCharacter();
        player = new Player("Quack", quack, weapon, 100, "Easy");
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
        clickOn("Medium");
        clickOn("Katana");
        clickOn("Quack");
        clickOn("Start Game");
        verifyThat("Gold: 50", NodeMatchers.isNotNull());
    }
}
