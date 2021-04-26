package quack.models.monsters;

import quack.models.GameObject;
import quack.models.GameState;

public class Projectile extends GameObject {
    private boolean attacking = false;

    public Projectile() {
        super("src/main/resources/assets/monsters/FinalBossAttack.gif", 500);
    }

    @Override
    public void update() {
        if (attacking) {
            updateImage("src/main/resources/assets/monsters/FinalBossAttack.gif");
        } else {
            GameState.getInstance().getCurrentRoom().getGameObjects().remove(this);
        }
    }

    public void setAttacking(boolean attack) {
        this.attacking = attack;
    }
}
