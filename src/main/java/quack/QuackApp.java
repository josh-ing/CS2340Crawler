package quack;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import javafx.beans.binding.StringBinding;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class QuackApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(700);
        gameSettings.setHeight(500);
        gameSettings.setTitle("Quack");
        gameSettings.setVersion("0.0.1");
        gameSettings.setMainMenuEnabled(true);
        gameSettings.setSceneFactory(new QuackSceneFactory());
    }



    public static void main(String[] args) {
        launch(args);
    }
}
