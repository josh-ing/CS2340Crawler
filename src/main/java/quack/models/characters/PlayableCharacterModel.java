package quack.models.characters;

public class PlayableCharacterModel {

    private int maxHealth;
    private int maxMana;
    private int power;
    private int speed;
    private String imageAsset;

    public PlayableCharacterModel(int maxHealth, int maxMana, int power, int speed, String imageAsset) {
        this.maxHealth = maxHealth;
        this. maxMana = maxMana;
        this.power = power;
        this.speed = speed;
        this.imageAsset = imageAsset;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getImageAsset() {
        return imageAsset;
    }
}
