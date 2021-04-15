package quack.models.items;

import quack.models.GameState;
import quack.models.Player;

public class HealthPotion extends Item {

    public HealthPotion() {
        super("src/main/resources/assets/items/healthPotion.png");
    }

    @Override
    public void use() {
        GameState.getInstance().setUsedItem(this);
        GameState.getInstance().getInventory().getItems().remove(this);
        Player player = GameState.getInstance().getPlayer();
        player.setCurrHealth(player.getCurrHealth() + 200);
    }

    @Override
    public void unUse() {
    }
}
