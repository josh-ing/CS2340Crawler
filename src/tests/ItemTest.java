
import org.junit.jupiter.api.Test;
import quack.models.GameState;
import quack.models.Player;
import quack.models.characters.QuackCharacter;
import quack.models.items.AttackPotion;
import quack.models.items.HealthPotion;
import quack.models.items.Item;
import quack.models.items.SuperPotion;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.LongSwordWeapon;
import quack.models.weapons.Weapon;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void superPotionTest() {
        Item item = new SuperPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new LongSwordWeapon();
        Player player = new Player("Pelican", character, weapon, 100);

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldRange = GameState.getInstance().getPlayer().getCurrAttack();

        item.use();

        assertEquals(oldRange + 10, GameState.getInstance().getPlayer().getCurrAttack());
    }

    @Test
    public void healthPotionTest() {
        Item item = new HealthPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KatanaWeapon();
        Player player = new Player("Quack", character, weapon, 100);

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldHealth = GameState.getInstance().getPlayer().getCurrHealth();

        item.use();

        assertEquals(oldHealth + 200, GameState.getInstance().getPlayer().getCurrHealth());
    }

    @Test
    public void attackPotionTest() {
        Item item = new AttackPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KatanaWeapon();
        Player player = new Player("Quack", character, weapon, 100);

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        item.use();

        assertEquals(oldAttack + 10, GameState.getInstance().getPlayer().getCurrAttack());
    }

    @Test
    public void weaponTest() {
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new LongSwordWeapon();
        Player player = new Player("Pelican", character, weapon, 100);

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        weapon.use();

        assertEquals(oldAttack, GameState.getInstance().getPlayer().getCurrAttack());
    }

    @Test
    public void separateWeaponTest() {
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KnifeWeapon();
        Player player = new Player("Quack", character, weapon, 100);

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        weapon.use();

        assertEquals(oldAttack, GameState.getInstance().getPlayer().getCurrAttack());
    }
}
