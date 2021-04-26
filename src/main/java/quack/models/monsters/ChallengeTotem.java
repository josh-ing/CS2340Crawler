package quack.models.monsters;

import quack.models.Attackable;
import quack.models.GameState;

public class ChallengeTotem extends Monster implements Attackable {
    public ChallengeTotem() {
        super(1, 0, 1, "src/main/resources/assets/monsters/totem.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void damage(int damage) {
        setHealth(getHealth() - damage);

        if (getHealth() <= 0) {
            GameState.getInstance().getCurrentRoom().getGameObjects().remove(this);
            GameState.getInstance().getCurrentRoom().spawnMonsters(0, 0, 10);
        }
    }

}
