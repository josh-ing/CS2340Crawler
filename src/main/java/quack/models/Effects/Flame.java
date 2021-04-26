package quack.models.Effects;

import javafx.scene.image.Image;


public class Flame extends Animations {
    public Flame() { super("src/main/resources/assets/damage animations/FinalBossAttack.gif", 500);}

    public Image getSprite() {
        return this.getSpriteAsset();
    }

    @Override
    public void update() {

    }
}
