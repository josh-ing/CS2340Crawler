package quack.models.characters;

public class PelicanCharacter extends Character {
    private String asset;

    public PelicanCharacter() {
        super(2000, 10, 10, "src/main/resources/assets/characters/pelicanchar.png");
        this.asset = "src/main/resources/assets/characters/pelicanchar.png";
    }

    public String getAsset() {
        return asset;
    }
}
