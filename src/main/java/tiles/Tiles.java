package tiles;

import java.util.HashMap;
import java.util.Map;

/**
 * The Tiles class is a holder for different types of Tiles
 * 
 * @author jpconver
 *
 */
public class Tiles {
    
    private Map<Integer,Tile> tiles;
    
    public Tiles() {
        this.tiles = new HashMap<Integer,Tile>();
    }
    
    public void addTile(Tile tile) {
        this.tiles.put(tile.getId(), tile);
    }
    
    public Tile getTile(int id) {
        return tiles.get(id);
    }

}
