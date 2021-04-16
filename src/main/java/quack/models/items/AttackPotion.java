package quack.models.items;

import quack.models.GameState;
import quack.models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class AttackPotion extends Item {

    private static final int DURATION = 30;

    public AttackPotion() {
        super("src/main/resources/assets/items/attackPotion.png");
    }

    @Override
    public void use() {
        GameState.getInstance().setUsedItem(this);
        GameState.getInstance().getInventory().getItems().remove(this);
        Player player = GameState.getInstance().getPlayer();
        player.setCurrAttack(player.getCurrAttack() + 10);

        Timer durationTimer = new Timer(true);
        durationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameState.getInstance().setUsedItem(null);
            }
        }, DURATION * 1000);
    }

    @Override
    public void unUse() {
        Player player = GameState.getInstance().getPlayer();
        player.setCurrAttack(player.getCurrAttack() - 10);
    }

}
