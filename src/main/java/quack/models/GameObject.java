package quack.models;

import javafx.scene.image.Image;

public abstract class GameObject {

    public enum Rotation {
        RIGHT,
        UP,
        LEFT,
        DOWN
    }

    private int row;
    private int col;
    private Rotation rotation;
    private Image imageAsset;

    public abstract void update(long l);

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
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
}
