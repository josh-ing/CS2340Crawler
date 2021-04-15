import org.junit.Test;
import quack.models.characters.HenryCharacter;
import quack.models.characters.PelicanCharacter;
import quack.models.characters.QuackCharacter;


import static org.junit.Assert.assertEquals;

public class CharacterTest {

    private QuackCharacter quack;
    private HenryCharacter henry;
    private PelicanCharacter pelican;

    @Test
    public void testPlayerQuack() {
        quack = new QuackCharacter();
        assertEquals(quack.getAsset(), "src/main/resources/assets/quack.gif");
    }

    @Test
    public void testPlayerHenry() {
        henry = new HenryCharacter();
        assertEquals(henry.getAsset(), "src/main/resources/assets/henry.gif");
    }

    @Test
    public void testPlayerPelican() {
        pelican = new PelicanCharacter();
        assertEquals(pelican.getAsset(), "src/main/resources/assets/characters/pelicanchar.png");
    }




}
