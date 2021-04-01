package quack.models.monsters;

import quack.models.GameState;
import quack.models.Player;
import quack.models.Position;

public class BasicMonster extends Monster {

    public BasicMonster() {
        super(10, 10, 10, "src/main/resources/assets/monsters/monster.png");
    }

    public void attack() {
        Position attackPosition;
        if (getRotation() == Rotation.RIGHT) {
            attackPosition = getPosition().translateRight();
        } else if(getRotation() == Rotation.UP) {
            attackPosition = getPosition().translateUp();
        } else if(getRotation() == Rotation.LEFT) {
            attackPosition = getPosition().translateLeft();
        } else {
            attackPosition = getPosition().translateDown();
        }
        Player player = GameState.getInstance().getPlayer();
        if (player.getPosition() == attackPosition) {
            player.setCurrHealth(player.getCurrHealth() - getAttack());
        }
    }
}