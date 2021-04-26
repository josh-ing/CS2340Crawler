package quack.models.characters;

public class HenryCharacter extends Character {
    private String asset;

    public HenryCharacter()  {
        //change to 300
        super(2000, 10, 10, "src/main/resources/assets/henry.gif");
        this.asset = "src/main/resources/assets/henry.gif";
    }

    public String getAsset() {
        return asset;
    }
}
