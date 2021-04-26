package quack.models.Effects;

import javafx.scene.image.Image;

public class KnifeAnim extends Animations {
    private Image sprite;

    public KnifeAnim() { super("src/main/resources/assets/damage animations/knife.gif");}

    public Image getSprite() { return sprite; }
}
