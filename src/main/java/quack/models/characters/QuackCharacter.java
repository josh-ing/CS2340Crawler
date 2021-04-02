package quack.models.characters;

public class QuackCharacter extends Character {
    private String asset;

    public QuackCharacter() {
        super(2000, 10, 10, "src/main/resources/assets/characters/quackchar.png");
        this.asset = "src/main/resources/assets/characters/quackchar.png";
    }

    public String getAsset() {
        return asset;
    }
}
