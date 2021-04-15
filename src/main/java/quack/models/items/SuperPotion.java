package quack.models.items;

import quack.models.GameState;
import quack.models.Player;

public class SuperPotion extends Item {

    public SuperPotion() {
        super("src/main/resources/assets/items/rangePotion.png");
    }

    @Override
    public void use() {
        GameState.getInstance().setUsedItem(this);
        GameState.getInstance().getInventory().getItems().remove(this);
        Player player = GameState.getInstance().getPlayer();

        player.setCurrHealth(player.getCurrHealth() + 200);
        player.setCurrAttack(player.getCurrAttack() + 10);
    }

    @Override
    public void unUse() {
        Player player = GameState.getInstance().getPlayer();

        player.setCurrAttack(player.getCurrAttack() - 10);
    }
}
