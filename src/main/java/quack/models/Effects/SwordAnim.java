package quack.models.Effects;

import javafx.scene.image.Image;

public class SwordAnim extends Animations{
    private Image sprite;

    public SwordAnim() { super("src/main/resources/assets/damage animations/sword.gif");}

    public Image getSprite() { return sprite; }
}
