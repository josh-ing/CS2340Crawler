package quack.models.Effects;

import javafx.scene.image.Image;
import quack.models.GameObject;
import quack.models.Position;
import quack.models.Renderable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Animations implements Renderable {
    private Image spriteAsset;
    private Position position;
    private GameObject.Rotation rotation;
    private long lastUpdate = 0;
    private long updatePeriod; //ms

    public Animations(String sprite, long updatePeriod) {
        this.updatePeriod = updatePeriod;
        try {
            this.spriteAsset = new Image(new FileInputStream(sprite));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(long l) {
        if (l > lastUpdate + updatePeriod) {
            lastUpdate = l;
            update();
        }
    }

    public abstract void update();

    public Image getSpriteAsset() {
        return spriteAsset;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setRotation(GameObject.Rotation rotation) {
        this.rotation = rotation;
    }
}
