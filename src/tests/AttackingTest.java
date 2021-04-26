import org.junit.jupiter.api.Test;
import quack.models.GameState;
import quack.models.Player;
import quack.models.characters.HenryCharacter;
import quack.models.characters.QuackCharacter;
import quack.models.monsters.EasyMonster;
import quack.models.monsters.HardMonster;
import quack.models.monsters.Monster;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.Weapon;

import static org.junit.Assert.assertEquals;


public class AttackingTest {

    private Player player;
    private Monster monster;

    @Test
    public void testMonsterAttackPlayer() {
        monster = new EasyMonster();
        Weapon weapon = new KatanaWeapon();
        QuackCharacter character = new QuackCharacter();
        player = new Player("Quack", character, weapon, 100, "Easy");

        monster.attack(player);

        assertEquals(player.getCurrHealth(), character.getMaxHealth() - monster.getAttack());
    }

    @Test
    public void testPlayerAttackMonster() {
        monster = new HardMonster();
        Weapon weapon = new KnifeWeapon();
        HenryCharacter character = new HenryCharacter();
        player = new Player("Quack", character, weapon, 100, "Easy");

        int initMonsterHealth = monster.getHealth();

        player.attack(monster);

        assertEquals(monster.getHealth(), initMonsterHealth - character.getAttack()
                - weapon.getAttack());
    }

    @Test
    public void testMonsterGold() {
        monster = new HardMonster();
        Weapon weapon = new KnifeWeapon();
        HenryCharacter character = new HenryCharacter();
        player = new Player("Quack", character, weapon, 100, "Easy");
        GameState.getInstance().setPlayer(player);
        assertEquals(100, player.getGold());

        while(monster.getHealth() > 0) {
            player.attack(monster);
        }

        assertEquals(110, player.getGold());
    }

}
