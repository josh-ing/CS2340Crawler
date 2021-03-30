package quack.models;
import quack.models.characters.MonsterStatModel;

public class MonsterModel {
    private int currHealth;
    private int dmgPerHit;
    private int speed;

    public MonsterModel(int currHealth, int dmgPerHit, int speed) {
        this.currHealth = currHealth;
        this.dmgPerHit = dmgPerHit;
        this.speed = speed;
    }

    /**
     * Creates the easy monster
     */
    private MonsterStatModel createEasyMonster() {
        MonsterStatModel monster = new MonsterStatModel(1,1,1, MonsterStatModel.MonsterType.EASY);
        return monster;
    }
    /**
     * Creates the medium monster
     */
    private MonsterStatModel createMedMonster() {
        MonsterStatModel monster = new MonsterStatModel(5,2,3, MonsterStatModel.MonsterType.MEDIUM);
        return monster;
    }
    /**
     * Creates the hard monster
     */
    private MonsterStatModel createHardMonster() {
        MonsterStatModel monster = new MonsterStatModel(10,5,5, MonsterStatModel.MonsterType.HARD);
        return monster;
    }
    /**
     * Creates the boss monster
     */
    private MonsterStatModel createBossMonster() {
        MonsterStatModel monster = new MonsterStatModel(15,7,7, MonsterStatModel.MonsterType.BOSS);
        return monster;
    }
}
