package quack;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public class QuackMenu extends FXGLMenu {
    Button button;
    public QuackMenu(@NotNull MenuType type) {
        super(type);
        button = new Button("Click Here");
        this.getContentRoot().getChildren().add(button);
    }

    protected Node createTitleView(String title) {
        return new Text(title);
    }


}
