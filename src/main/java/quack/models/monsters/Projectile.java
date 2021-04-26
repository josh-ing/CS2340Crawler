package quack.models.monsters;

import quack.models.GameObject;

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
            updateImage(null);
        }
    }

    public void setAttacking(boolean attack) {
        this.attacking = attack;
    }
}
