package quack.models;

import javafx.scene.image.Image;

public abstract class GameObject {

    public enum Rotation {
        RIGHT,
        UP,
        LEFT,
        DOWN
    }

    private int x;
    private int y;
    private Rotation rotation;
    private Image imageAsset;

    public abstract void update();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImageAsset() {
        return imageAsset;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }
}
