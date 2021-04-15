package quack.models.items;

public class healthPotion extends Item {

    public healthPotion(int healthRegen, int attackInc, int rangeLInc, int rangeWInc, String sprite) {
        super( 3, 0, 0, 0, "src/main/resources/assets/items/healthPotion.png");
    }
}
