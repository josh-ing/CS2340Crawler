import org.junit.Test;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Player;
import quack.models.characters.PelicanCharacter;
import quack.models.monsters.ChallengeTotem;
import quack.models.monsters.HardMonster;
import quack.models.weapons.LongSwordWeapon;
import quack.models.weapons.Weapon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChallengeTest {

    @Test
    public void totemSpawnsMonsters() {
        ChallengeTotem totem = new ChallengeTotem();
        PelicanCharacter pelly = new PelicanCharacter();
        Weapon sword = new LongSwordWeapon();
        Player player = new Player("Pelly", pelly, sword, 500, "Easy");
        int totemHealth = totem.getHealth();

        while (totem.getHealth() > 0) {
            player.attack(totem);
        }

        boolean hasHardMonster = false;
        for (GameObject go : GameState.getInstance().getCurrentRoom().getGameObjects()) {
            if (go instanceof HardMonster) {
                hasHardMonster = true;
            }
        }

        assertTrue(hasHardMonster);
    }


    @Test
    public void attackTotem() {
        ChallengeTotem totem = new ChallengeTotem();
        PelicanCharacter pelly = new PelicanCharacter();
        Weapon sword = new LongSwordWeapon();
        Player player = new Player("Pelly", pelly, sword, 500, "Easy");
        int totemHealth = totem.getHealth();
        player.attack(totem);
        assertEquals(totem.getHealth(), totemHealth - pelly.getAttack() - sword.getAttack());
    }

    @Test
    public void testMonstersSpawn() {
        ChallengeTotem totem = new ChallengeTotem();
        PelicanCharacter pelly = new PelicanCharacter();
        Weapon sword = new LongSwordWeapon();
        Player player = new Player("Pelly", pelly, sword, 500, "Easy");
        GameState.getInstance();
        GameState.getInstance().getCurrentRoom().spawnMonsters(0, 0, 10);
    }
}
