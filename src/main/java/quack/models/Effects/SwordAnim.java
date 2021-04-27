package quack.models.Effects;

import javafx.scene.image.Image;
import quack.models.GameState;

public class SwordAnim extends Animations {

    public SwordAnim() {
        super("src/main/resources/assets/damage animations/sword.gif", 500);
    }

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
