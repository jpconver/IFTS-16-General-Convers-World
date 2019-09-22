package application;

import java.awt.Graphics;

import tiles.Tile;
import utils.Utils;

/**
 * The world class holds information of the tiles that conform the map of the game.
 * It delegate the tick() calls to the EntityManager and it renders the current visible world in the render() method
 *
 * @author jpconver
 */
public class World {

    private int width, height;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick() {
        Application.getInstance().getEntityManager().tick();
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, Application.getInstance().getCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (Application.getInstance().getCamera().getxOffset() + Application.getInstance().getDisplay().getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, Application.getInstance().getCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (Application.getInstance().getCamera().getyOffset() + Application.getInstance().getDisplay().getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - Application.getInstance().getCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - Application.getInstance().getCamera().getyOffset()));
            }
        }
        Application.getInstance().getEntityManager().render(g);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
