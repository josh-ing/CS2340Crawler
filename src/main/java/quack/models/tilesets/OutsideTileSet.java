package quack.models.tilesets;

import java.io.FileNotFoundException;

public class OutsideTileSet extends TileSet {

    public OutsideTileSet() {
        super("src/main/resources/assets/tiles/dungeon_floor.jpg", "src/main/resources/assets/tiles/dungeon_wall.jpg"
        , "src/main/resources/assets/tiles/portal.jpg");
    }
}
