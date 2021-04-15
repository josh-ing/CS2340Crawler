package quack.models.items;

public class attackPotion extends Item {

    public attackPotion(int healthRegen, int attackInc, int rangeLInc, int rangeWInc, String sprite) {
        super( 0, 3, 0, 0, "src/main/resources/assets/items/attackPotion.png");
    }
}
