package quack.models.items;

import javafx.scene.image.Image;
import quack.models.Renderable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item implements Renderable {

    private Image spriteImage;

    public Item(String sprite) {
        try {
            spriteImage = new Image(new FileInputStream(sprite));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void use();

    public abstract void unUse();

    public Image getSprite() {
        return spriteImage;
    }
}
