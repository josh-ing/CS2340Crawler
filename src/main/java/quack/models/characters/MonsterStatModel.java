package quack.models.characters;

/**
 * A class that represents the stats of a starting monster
 * in the game. Includes max health, damage per hit, and speed
 */
public class MonsterStatModel {
    private int maxHealth;
    private int dmgPerHit;
    private int speed;
    private MonsterType type;

    public enum MonsterType {
        EASY, //Health 1, Dmg 1, Spd 1
        MEDIUM, //Health 5, Dmg 2, Spd 3
        HARD, //Health 10, Dmg 5, Spd 5
        BOSS //Health 15, Dmg 7, Spd 7
    }

    /**
     * Initialize the stats for a monster
     * @param maxHealth The maximum health of a monster
     * @param dmgPerHit Damage done to the player with each hit
     * @param speed How fast the monster can move
     */
    public MonsterStatModel(int maxHealth, int dmgPerHit, int speed, MonsterType type) {
        this.maxHealth = maxHealth;
        this.dmgPerHit = dmgPerHit;
        this.speed = speed;
        this.type = type;
    }

    /**
     * Initializes values of max health, damage, and speed
     */
    public MonsterStatModel() {
        this(1, 1, 1, MonsterType.EASY);
    }

    /**
     * Sets the max health of monster
     */
    public void setMaxHealth() {
        this.maxHealth = maxHealth;
    }
    /**
     * Gets the max health of monster
     */
    public int getMaxHealth() {
        return maxHealth;
    }
    /**
     * Sets the damage per hit of monster
     */
    public void setDmgPerHit() {
        this.dmgPerHit = dmgPerHit;
    }
    /**
     * Sets the damage per hit of monster
     */
    public int getDmgPerHit() {
        return dmgPerHit;
    }
    /**
     * Sets the speed of monster
     */
    public void setSpeed() {
        this.speed = speed;
    }
    /**
     * Gets the speed of monster
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Sets Monster type
     */
    public void setMonsterType(MonsterType type) {
        this.type = type;
    }
    /**
     * Gets Monster type
     */
    public MonsterType getMonsterType() {
        return type;
    }


}
