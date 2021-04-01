package quack.models;

import javafx.scene.image.Image;

public abstract class GameObject {

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

    public abstract void update(long l);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Image getImageAsset() {
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

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }
}
