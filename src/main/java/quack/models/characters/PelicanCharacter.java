package quack.models.characters;

public class PelicanCharacter extends Character {
    private String asset;

    public PelicanCharacter() {
        super(2000, 10, 10, "src/main/resources/assets/chicken.gif");
        this.asset = "src/main/resources/assets/chicken.gif";
    }

    public String getAsset() {
        return asset;
    }
}
