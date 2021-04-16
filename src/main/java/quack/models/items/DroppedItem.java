package quack.models.items;

import javafx.scene.image.Image;
import quack.models.GameObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DroppedItem extends GameObject {
    private Item item;

    public DroppedItem(Item item) {
        super(item.getSprite());

    }

    @Override
    public void update() {

    }

    public void setItem(Item item) {
        this.item = item;
        this.setImageAsset(item.getSprite());
    }

    public Item getItem() {
        return item;
    }
}
