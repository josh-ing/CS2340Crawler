import org.junit.jupiter.api.Test;
import quack.models.GameState;
import quack.models.Player;
import quack.models.characters.QuackCharacter;
import quack.models.monsters.Monster;
import quack.models.weapons.KnifeWeapon;

import static org.junit.Assert.assertEquals;

public class GameStateTest {

    @Test
    public void testGameObjectSize() {
        GameState gameState = GameState.getInstance();
        Player player = new Player("Bot", new QuackCharacter(), new KnifeWeapon(), 100, "Easy");
        gameState.setPlayer(player);
        assertEquals(gameState.getCurrentRoom().getGameObjects().size(), 1);
        gameState.setCurrentRoom(gameState.getCurrentRoom().getNeighbors()[0]);
        assertEquals(gameState.getCurrentRoom().getGameObjects().size(), 7);
        for (int i = 0; i < gameState.getCurrentRoom().getGameObjects().size();) {
            if (gameState.getCurrentRoom().getGameObjects().get(i) instanceof Monster) {
                ((Monster) gameState.getCurrentRoom().getGameObjects().get(i)).damage(9999999);
            } else {
                i++;
            }
        }
        assertEquals(gameState.getCurrentRoom().getGameObjects().size(), 6);
        gameState.setCurrentRoom(gameState.getCurrentRoom().getNeighbors()[2]);
        assertEquals(gameState.getCurrentRoom().getGameObjects().size(), 1);
        gameState.setCurrentRoom(gameState.getCurrentRoom().getNeighbors()[0]);
        assertEquals(gameState.getCurrentRoom().getGameObjects().size(), 5);
    }

    @Test
    public void testGetVisitedRooms() {
        GameState.reset();
        GameState gameState = GameState.getInstance();
        Player player = new Player("Bot", new QuackCharacter(), new KnifeWeapon(), 100, "Easy");
        gameState.setPlayer(player);
        assertEquals(gameState.getVisitedRooms().size(), 1);
        gameState.setCurrentRoom(gameState.getCurrentRoom().getNeighbors()[0]);
        assertEquals(gameState.getVisitedRooms().size(), 2);
        gameState.setCurrentRoom(gameState.getCurrentRoom().getNeighbors()[2]);
        assertEquals(gameState.getVisitedRooms().size(), 2);
    }

}
