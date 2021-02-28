package quack.models.weapons;

/**
 * Class representing a weapon
 */
public class WeaponModel {

    public enum WeaponType {
        knife, bow, wand
    }

    private WeaponType weaponType;
    private int damage;
    private int attackSpeed;
    private String imageAsset; //This is a temp place holder variable for the image asset.

    public WeaponModel(WeaponType weaponType, int damage, int attackSpeed, String imageAsset) {
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.imageAsset = imageAsset;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public String getImageAsset() {
        return imageAsset;
    }









}
