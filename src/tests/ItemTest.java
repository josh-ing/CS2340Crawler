import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Test;
import quack.models.GameObject;
import quack.models.GameState;
import quack.models.Player;
import quack.models.Position;
import quack.models.characters.QuackCharacter;
import quack.models.items.*;
import quack.models.weapons.KatanaWeapon;
import quack.models.weapons.KnifeWeapon;
import quack.models.weapons.LongSwordWeapon;
import quack.models.weapons.Weapon;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void healthPotionTest() {
        Item item = new HealthPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KatanaWeapon();
        Player player = new Player("Quack", character, weapon, 100, "Easy");

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
        Player player = new Player("Quack", character, weapon, 100, "Easy");

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        item.use();

        assertEquals(oldAttack + 10, GameState.getInstance().getPlayer().getCurrAttack());
    }

    @Test
    public void attackPotionDurationTest() {
        Item item = new AttackPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KatanaWeapon();
        Player player = new Player("Quack", character, weapon, 100, "Easy");

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        item.use();

        assertEquals(oldAttack + 10, GameState.getInstance().getPlayer().getCurrAttack());

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(oldAttack, GameState.getInstance().getPlayer().getCurrAttack());

    }

    @Test
    public void superPotionDurationTest() {
        Item item = new SuperPotion();
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KatanaWeapon();
        Player player = new Player("Quack", character, weapon, 100, "Easy");

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        item.use();

        assertEquals(oldAttack + 10, GameState.getInstance().getPlayer().getCurrAttack());

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(oldAttack, GameState.getInstance().getPlayer().getCurrAttack());

    }

    @Test
    public void weaponTest() {
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new LongSwordWeapon();
        Player player = new Player("Pelican", character, weapon, 100, "Easy");

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
        Player player = new Player("Quack", character, weapon, 100, "Easy");

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        int oldAttack = GameState.getInstance().getPlayer().getCurrAttack();

        weapon.use();

        assertEquals(oldAttack, GameState.getInstance().getPlayer().getCurrAttack());
    }

    @Test
    public void openChestTest() {
        QuackCharacter character = new QuackCharacter();
        Weapon weapon = new KnifeWeapon();
        Player player = new Player("Quack", character, weapon, 100, "Easy");
        player.setPosition(new Position(5, 5));
        player.setRotation(GameObject.Rotation.UP);

        System.out.println(player.getFacingPosition().getRow());

        GameState.getInstance();
        GameState.getInstance().setPlayer(player);

        Chest chest = new Chest();
        chest.setPosition(new Position(4, 5));
        GameState.getInstance().appendInput(new KeyEvent(null, null, null, KeyCode.C,
                false, false, false, false));
        assertEquals(100, GameState.getInstance().getPlayer().getGold());
        chest.update();

        assertEquals(0, GameState.getInstance().getPlayer().getGold());
    }
}
