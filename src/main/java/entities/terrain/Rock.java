package entities.terrain;

import java.awt.Graphics;

import application.Application;
import tiles.Tile;

public class Rock extends StaticEntity {

    public Rock(float x, float y) {
        super(x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 3;
        bounds.y = (int) (height / 2f);
        bounds.width = width - 6;
        bounds.height = (int) (height - height / 2f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
                Application.getInstance().getAssets().getStaticAssets().get("rock"),
                (int) (x - Application.getInstance().getCamera().getxOffset()),
                (int) (y - Application.getInstance().getCamera().getyOffset()), width, height, null);
    }

}
