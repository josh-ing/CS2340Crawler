package quack.models;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class GameObject implements Renderable {

    public enum Rotation {
        RIGHT,
        UP,
        LEFT,
        DOWN
    }

    private Position position;
    private Rotation rotation;
    private Image imageAsset;
    private long lastUpdate = 0;
    private long updatePeriod; //ms

    public GameObject(String image, int updatePeriod) {
        this.updatePeriod = updatePeriod;

        try {
            this.imageAsset = new Image(new FileInputStream(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GameObject() {
        this("", 500);
    }

    public void update(long l) {
        if (l > lastUpdate + updatePeriod) {
            lastUpdate = l;
            update();
        }
    }

    public abstract void update();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Image getSprite() {
        return imageAsset;
    }

    public void setImageAsset(Image imageAsset) {
        this.imageAsset = imageAsset;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public long getUpdatePeriod() {
        return updatePeriod;
    }

    public void setUpdatePeriod(long updatePeriod) {
        this.updatePeriod = updatePeriod;
    }
}
