import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import quack.controllers.MainMenuController;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javafx.scene.Node;


public class MapTest extends ApplicationTest{
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        MainMenuController mainMenuController = new MainMenuController(stage);
        mainMenuController.initMainMenu();
    }


}
