import org.junit.Test;
import quack.models.Player;
import quack.models.characters.HenryCharacter;
import quack.models.characters.QuackCharacter;
import quack.models.monsters.Boss;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.Weapon;

import static org.junit.Assert.assertEquals;

public class BossTest {

    private Player player;
    private Boss boss;

    @Test
    public void bossAttack() {
        boss = new Boss();
        Weapon weapon = new KnifeWeapon();
        QuackCharacter quack = new QuackCharacter();
        player = new Player("Quack", quack, weapon, 500);
        boss.attack(player);

        assertEquals(player.getCurrHealth(), quack.getMaxHealth() - boss.getAttack());
    }

    @Test
    public void attackBoss() {
        boss = new Boss();
        Weapon katana = new KatanaWeapon();
        HenryCharacter henry = new HenryCharacter();
        player = new Player("Henry", henry, katana, 500);

        int bossHealth = boss.getHealth();
        player.attack(boss);

        assertEquals(boss.getHealth(), bossHealth - henry.getAttack() - katana.getAttack());
    }
}
