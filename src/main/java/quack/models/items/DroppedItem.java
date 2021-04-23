package quack.models.items;
import quack.models.GameObject;

public class DroppedItem extends GameObject {
    private Item item;

    public DroppedItem(Item item) {
        super(item.getSprite());
        this.item = item;

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
