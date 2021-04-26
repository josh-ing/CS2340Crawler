package quack.models.characters;

public class QuackCharacter extends Character {
    private String asset;

    public QuackCharacter() {
        super(200, 10, 10, "src/main/resources/assets/quack.gif");
        this.asset = "src/main/resources/assets/quack.gif";
    }

    public String getAsset() {
        return asset;
    }
}
