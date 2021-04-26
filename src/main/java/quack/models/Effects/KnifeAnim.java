package quack.models.Effects;

import javafx.scene.image.Image;
import quack.models.GameState;

public class KnifeAnim extends Animations {

    public KnifeAnim() { super("src/main/resources/assets/damage animations/knife.gif", 500);}

    public Image getSprite() {
        return this.getSpriteAsset();
    }


    @Override
    public void update() {
        if (!GameState.getInstance().getPlayer().getFacingPosition().equals(this.getPosition())) {
            GameState.getInstance().getEffectObjects().remove(this);
        }
    }
}
