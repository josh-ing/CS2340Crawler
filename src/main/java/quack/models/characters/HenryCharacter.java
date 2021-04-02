package quack.models.characters;

public class HenryCharacter extends Character {
    private String asset;

    public HenryCharacter()  {
        super(2000, 10, 10, "src/main/resources/assets/characters/henrychar.png");
        this.asset = "src/main/resources/assets/characters/henrychar.png";
    }

    public String getAsset() {
        return asset;
    }
}
